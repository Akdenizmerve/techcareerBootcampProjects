const chakram = require('chakram'), expect = chakram.expect;

describe("User Module", function () {

    it("POST - Create User", function() {
        const body = {
            "id": 3456,
            "username": "mervik",
            "firstName": "Merve",
            "lastName": "Akdeniz",
            "email": "mervik@gmail.com",
            "password": "224e581c",
            "phone": "05078601359",
            "userStatus": 0
        };
        const expectedRespBody = {
            "code": 200,
            "type": "unknown",
            "message": "3456"
        };
        const response = chakram.post("https://petstore.swagger.io/v2/user", body);
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    }); 

    it("GET - User Info", function() {
        const expectedRespBody = {
            "id": 3456,
            "username": "mervik",
        };
        const response = chakram.get("https://petstore.swagger.io/v2/user/mervik");
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });


    it("PUT - User Mervik", function() {
        const expectedRespBody = {
            "code": 200,
            "type": "unknown",
            "message": "3456"
        };
        const reqBody = {
            "id": 3456,
            "username": "mervik",
            "firstName": "Merve",
            "lastName": "Karadeniz",
            "email": "mervik@gmail.com",
            "password": "224e581c",
            "phone": "05078601359",
            "userStatus": 0
        };
        const response = chakram.put("https://petstore.swagger.io/v2/user/mervik", reqBody);
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });

    it("GET - Updated User Info", function() {
        const expectedRespBody = {
            "id": 3456,
            "username": "mervik",
        }
        const response = chakram.get("https://petstore.swagger.io/v2/user/mervik");
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });
    

    it("GET - Not Found User Info", function() {
        const expectedRespBody = {
            "code": 1,
            "type": "error",
            "message": "User not found"
        };
        const response = chakram.get("https://petstore.swagger.io/v2/user/dogan");
        expect(response).to.have.status(404);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });

    it("DELETE - User Mervik", function() {
        const expectedRespBody = {
            "code": 200,
            "type": "unknown",
            "message": "mervik"
        };
        const response = chakram.delete("https://petstore.swagger.io/v2/user/mervik");
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });

    it("GET - Deleted User Info", function() {
        const expectedRespBody = {
            "code": 1,
            "type": "error",
            "message": "User not found"
        };
        const response = chakram.get("https://petstore.swagger.io/v2/user/mervik");
        expect(response).to.have.status(404);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });

    it("POST - Create With Array", function() {
        var payload = [
            {
                "id": 7012024,
                "username": "yumak",
                "firstName": "yumak",
                "lastName": "akdeniz",
                "email": "yumak@kedi.com",
                "password": "miyav",
                "phone": "05078601359",
                "userStatus": 0
            },
            {
                "id": 8012024,
                "username": "limon",
                "firstName": "limon",
                "lastName": "dereli",
                "email": "limon@kus.com",
                "password": "cikcik",
                "phone": "05078601359",
                "userStatus": 0
            }
        ];
        const expectedRespBody = {
            "code": 200,
            "type": "unknown",
            "message": "ok"
        };
        const response = chakram.post("https://petstore.swagger.io/v2/user/createWithArray", payload);
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });

    it("POST - Create With List", function() {
        var payload = [
            {
                "id": 9012024,
                "username": "yumak",
                "firstName": "yumak",
                "lastName": "akdeniz",
                "email": "yumak@kedi.com",
                "password": "miyav",
                "phone": "05078601359",
                "userStatus": 0
            },
            {
                "id": 10012024,
                "username": "limon",
                "firstName": "limon",
                "lastName": "dereli",
                "email": "limon@kus.com",
                "password": "cikcik",
                "phone": "05078601359",
                "userStatus": 0
            }
        ];
        const expectedRespBody = {
            "code": 200,
            "type": "unknown",
            "message": "ok"
        };
        const response = chakram.post("https://petstore.swagger.io/v2/user/createWithList", payload);
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(expectedRespBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
    });

});