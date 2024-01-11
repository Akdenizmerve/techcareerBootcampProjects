from locust import HttpUser, between, task


class WebsiteUser(HttpUser):
    wait_time = between(5, 15)

    def userOlustur(self, id, username):
        payload = {
             "id": id,
             "username": username,
             "firstName": "mercann",
             "lastName": "kayan",
             "email": "kayan@gmail.com",
             "password": "mercan12353",
             "phone": "05078901397",
             "userStatus": 0}
        self.client.post("/v2/user", json=payload)

    @task
    def getUserInfo(self):
        self.userOlustur(22458781, "mervik345")
        self.client.get("/v2/user/mervik345")

    @task
    def userCreat(self):
        payload={
            "id": 224581,
            "username": "mervis123",
            "firstName": "mercan",
            "lastName": "kaya",
            "email": "kaya@gmail.com",
            "password": "mercan1233",
            "phone": "05078901397",
            "userStatus": 0}
        self.client.post("/v2/user", json=payload)

    @task
    def logout(self):
        self.client.get("/v2/user/logout")

    @task
    def login(self):
        self.client.get("/v2/user/login?username=dogan123&password=dogan")

    @task
    def deleteUser(self):
        self.userOlustur(224581, "mervis1893")
        self.client.delete("/v2/user/mervis1893")

    @task
    def updateUser(self):
        body={
            "id": 224581,
            "username": "mersi",
            "firstName": "mersi",
            "lastName": "merr",
            "email": "me@gmail.com",
            "password": "mer1233",
            "phone": "05078901397",
            "userStatus": 0
        }
        self.client.put("/v2/user/mersi", json=body)

    @task
    def createWithList(self):
        payload = [
            {
                "id": 23,
                "username": "akdeniz",
                "firstName": "mer",
                "lastName": "ak",
                "email": "akdeniz@gmail.com",
                "password": "234567",
                "phone": "355678904",
                "userStatus": 0
            },
            {
                "id": 24,
                "username": "akdeniz",
                "firstName": "mer",
                "lastName": "ak",
                "email": "akdeniz@gmail.com",
                "password": "234567",
                "phone": "355678904",
                "userStatus": 0
            }
        ]
        self.client.post("/v2/user/createWithList", json=payload)

    @task
    def createWithArray(self):
        payload = [
            {
             "id": 23,
             "username": "merviak",
             "firstName": "merve",
             "lastName": "akdeniz",
             "email": "merveakdeniz@gmail.com",
             "password": "123456",
             "phone": "0987557377",
             "userStatus": 0
            },
            {
             "id": 24,
             "username": "merviak25",
             "firstName": "mervis",
             "lastName": "akdeniz",
             "email": "merveakdeniz@gmail.com",
             "password": "1234567",
             "phone": "09876544",
             "userStatus": 0
            }
        ]
        self.client.post("/v2/user/createWithArray", json=payload)