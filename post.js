var dataMap = {
    displayName: "display_name1"
};

var jsonString = JSON.stringify(dataMap);

fetch("http://localhost:8080/member", {
    method: "POST",
    body: jsonString,
    headers: { "Content-type": "application/json; charset=UTF-8" },
})
    .then((result) => result.json())
    .then(console.log);
