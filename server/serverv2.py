import socket, os, json
from datetime import datetime
from _thread import start_new_thread

class User:
  def __init__(self, username, hostname, address, conn):
    self.username = username
    self.hostname = hostname
    self.address = address
    self.conn = conn

## Logs
def time():
    #current time for logs
    now = datetime.now()
    dt_string = now.strftime("%d/%m/%Y | %H:%M:%S")
    return dt_string


def log_message(path, message_log):
    #Logs during server execution
    with open(os.path.join(path), "a") as file_logs:
        file_logs.write(f"{time()} : {message_log}\n")

def log_file_manage(log_path):
    #Create log file at start of main if doesn't exist
    is_file = os.path.isfile(log_path)
    if is_file is False:
        with open(os.path.join(log_path), "x") as file_logs:
            file_logs.write(f"{time()} : Server started\n")
            file_logs.close()
    else:
        with open(os.path.join(log_path), "a") as file_logs:
            file_logs.write(f"{time()} : Server started\n")
            file_logs.close()

def startServer(port):
    log_file_manage("server/server.log")
    host = socket.gethostname()
    print("[+] Server address at", host)

    server_socket = socket.socket()
    print("[-] Socket Created")
    server_socket.bind((host, port))
    print("[-] Socket Bound to port 5000")
    server_socket.listen(10)
    print("[-] Listening...")

    return server_socket

def sendOthers(conn_user, data, array):
    try:
        for user in array:
            if (user[1] != conn_user):
                user[1].send(data.encode())
    except IOError:
        print("oof")

def newUser(conn_user, address, array):
    for user in array:
        if (user[1] == conn_user):
            print("User already exists")
            break
    array.append(['', conn])


def client_thread(conn, users):
    msg_data = "Welcome to the Server. Type messages and press enter to send.\n"
    conn.send(msg_data.encode())

    while True:
        try:
            json_data = conn.recv(1024).decode()
            json_data = address[0] + ":" + str(address[1]) +" -> "+ json_data
            sendOthers(conn, json_data, users)
        except ConnectionResetError:
            print("disconnected")
    conn.close()

if __name__ == '__main__':
    server_socket = startServer(5000)
    users = []

    while True:
        conn, address = server_socket.accept()
        
        print("[-] Connected to " + address[0] + ":" + str(address[1]))
        conmsg = "[-] " + address[0] + ":" + str(address[1]) + " joined !"
        log_message("server/server.log", conmsg)
        sendOthers(conn, conmsg, users)
        newUser(conn, address, users)
        start_new_thread(client_thread, (conn, users,))
    server_socket.close()