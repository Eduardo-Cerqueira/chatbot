import socket
from _thread import start_new_thread

def sendOthers(conn_user, data, array):
    try:
        for user in array:
            if (user != conn_user):
                user.send(data.encode())
    except IOError:
        print("oof")

def newUser(conn_user, address, array):
    for user in array:
        if (user == conn_user):
            print("User already exists")
            break
    array.append(conn)


def client_thread(conn, users):
    msg_data = "Welcome to the Server. Type messages and press enter to send.\n"
    conn.send(msg_data.encode())

    while True:
        try:
            data = conn.recv(1024).decode()
            print("[+] data from "+ address[0] + ":" + str(address[1]) +" : " + data)
            if not data:
                break
            sendOthers(conn, data, users)
        except ConnectionResetError:
            print("disconnected")
    conn.close()

if __name__ == '__main__':
    host = socket.gethostname()
    print("[+] Server address at", host)

    server_socket = socket.socket()
    print("[-] Socket Created")
    server_socket.bind((host, 5000))
    print("[-] Socket Bound to port 5000")
    server_socket.listen(10)
    print("Listening...")

    users = []

    while True:
        conn, address = server_socket.accept()
        print("[-] Connected to " + address[0] + ":" + str(address[1]))
        conmsg = "[-]" + address[0] + ":" + str(address[1]) + " joined !"
        sendOthers(conn, conmsg, users)
        start_new_thread(newUser, (conn, address, users,))
        start_new_thread(client_thread, (conn, users,))
    server_socket.close()