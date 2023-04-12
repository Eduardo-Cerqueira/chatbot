import socket, json, _thread, os
from datetime import datetime

class user:
  def __init__(self, username, hostname):
    self.username = username
    self.hostname = hostname

def startServer(port):
    # get the hostname
    host = socket.gethostname()
    print(host)

    server_socket = socket.socket()  # get instance
    # look closely. The bind() function takes tuple as argument
    server_socket.bind((host, port))  # bind host address and port together

    # configure how many client the server can listen simultaneously
    server_socket.listen(2)

    last_adress = ""

    while True:
        conn, address = server_socket.accept()
        if (address != ""):
            log_message("server/server.log", "Connection", address)
            print("Connection from: " + str(address))
            last_adress = address
            address = ""

        # receive data stream. it won't accept data packet greater than 1024 bytes
        data = conn.recv(1024).decode()
        if not data:
            # if data is not received break
            break
        print("from connected user: " + data)
        print(data)
        json_data = json.loads(data)
        try:
            checkUser(users, json_data["username"], json_data["hostname"])
        except KeyError:
            print("Message don't contain username")
        break
        #data = input(' -> ')
        #sendMessage(conn, data)  # send data to the client
    log_message("server/server.log", "Disconnection", last_adress)
    conn.close()  # close the connection

#Thread: https://docs.python.org/3/library/_thread.html
def newThread(function):
    thread.start_new_thread(function)

def checkUser(users_array, username, hostname):
    for user in users_array:
        if (user.username == username):
            return print({'status': 500, 'err': 'Username already exists !'})
    print({'status': 200, 'err': "Username doesn't exist !"})
    addUser(users_array, username, hostname)
    print(users_array[0].username)
    return print({'status': 200, 'err': "Username created !"})


def addUser(users_array, username, hostname):
    return users_array.append(user(username, hostname))

def removeUser(users_array, username):
    i = 0
    for user in users_array:
        if (user.username == username):
            return users_array.pop(i)
        i+=1

def sendMessage(conn, data):
    return conn.send(data.encode())

## Logs
def time():
    #current time for logs
    now = datetime.now()
    dt_string = now.strftime("%d/%m/%Y | %H:%M:%S")
    return dt_string


def log_message(path, message_log, address):
    #Logs during server execution
    with open(os.path.join(path), "a") as file_logs:
        file_logs.write(f"{time()} - {address} : {message_log}\n")

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

if __name__ == '__main__':
    users = []
    log_file_manage("server/server.log", )
    startServer(5000)