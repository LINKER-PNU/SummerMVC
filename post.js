var dataMap = {
    authToken: "auth_token1",
    displayName: "display_name1",
    userId: "user_id1",
    newPlayer: "true",
};

var jsonString = JSON.stringify(dataMap);

fetch("http://localhost:8080/login", {
    method: "POST",
    body: jsonString,
    headers: { "Content-type": "application/json; charset=UTF-8" },
})
    .then((result) => result.json())
    .then(console.log);
