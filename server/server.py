import socket, json

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
    conn, address = server_socket.accept()  # accept new connection
    print("Connection from: " + str(address))
    while True:
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
        data = input(' -> ')
        conn.send(data.encode())  # send data to the client

    conn.close()  # close the connection

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

if __name__ == '__main__':
    users = []
    startServer(5000)