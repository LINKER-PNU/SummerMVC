# BoardAPI

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/board/list" %}
{% api-method-summary %}
getBoards
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="boardRoom" type="string" required=true %}
Room name, where the boards belong.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Response boards information complete successfully.
{% endapi-method-response-example-description %}

```text
{ result : [{
    boardAssignment: true
    boardDeadline: "2000-01-01 00:00:00"
    boardEditDt: "2000-01-01 00:00:00"
    boardId: 1
    boardNotice: false
    boardTitle: "title"
    boardVisible: false
    boardWriteDt: "2000-01-01 00:00:00"
    boardWriter: "name"
    boardWriterId: "id"
},
{
    boardAssignment: true
    boardDeadline: "2000-01-01 00:00:00"
    boardEditDt: "2000-01-01 00:00:00"
    boardId: 3
    boardNotice: false
    boardTitle: "title3"
    boardVisible: false
    boardWriteDt: "2000-01-01 00:00:00"
    boardWriter: "name2"
    boardWriterId: "id2"
}],
 resultCode : 200
}
```

{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/board/content" %}
{% api-method-summary %}
getBoardContent
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="boardId" type="integer" required=true %}
ID of the board you clicked. The content will response by string not json.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Response content as string, not json format.
{% endapi-method-response-example-description %}

```
Hello world!
```

{% endapi-method-response-example %}
{% endapi-method-response %}

{% api-method-response-example httpCode=400 %}
{% api-method-response-example-description %}
Response content as string, not json format.
{% endapi-method-response-example-description %}

```
WARN 400, there is no content or board. One of those is null.
```

{% endapi-method-response-example %}
{% endapi-method-response %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Response content as string, not json format.
{% endapi-method-response-example-description %}

```
ERROR 500, failed to request query to DB...
```

{% endapi-method-response-example %}
{% endapi-method-response %}

{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/board/insert" %}
{% api-method-summary %}
insertBoard
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="boardRoom" type="string" required=true %}
Room name, where the board belongs.
{% endapi-method-parameter %}

{% api-method-parameter name="boardWriterId" type="string" required=true %}
The board writer's user ID.
{% endapi-method-parameter %}

{% api-method-parameter name="boardTitle" type="string" required=true %}
Title of the board.
{% endapi-method-parameter %}

{% api-method-parameter name="boardContent" type="string" required=true %}
Content of the board.
{% endapi-method-parameter %}

{% api-method-parameter name="boardDeadline" type="string" required=false %}
Deadline of the board if it is assignment.  
Format : yyyy-MM-dd hh:mm:ss  
2020-01-01 00:00:00  
If the board doesn't need deadline, you don't have to send this field.
{% endapi-method-parameter %}

{% api-method-parameter name="boardNotice" type="boolean" required=true %}
Is the board notice.
{% endapi-method-parameter %}

{% api-method-parameter name="boardAssignment" type="boolean" required=true %}
Is the board assignment.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Board insert complete successfully.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 200 }
```

{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```

{% endapi-method-response-example %}

{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/board/edit" %}
{% api-method-summary %}
editBoard
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="boardId" type="integer" required=true %}
ID of the board you edited.
{% endapi-method-parameter %}

{% api-method-parameter name="boardTitle" type="string" required=true %}
Title of the board.
{% endapi-method-parameter %}

{% api-method-parameter name="boardContent" type="string" required=true %}
Content of the board.
{% endapi-method-parameter %}

{% api-method-parameter name="boardDeadline" type="string" required=false %}
Deadline of the board if it is assignment.  
Format : yyyy-MM-dd hh:mm:ss  
2020-01-01 00:00:00  
If the board doesn't need deadline, you don't have to send this field.
{% endapi-method-parameter %}

{% api-method-parameter name="boardNotice" type="boolean" required=true %}
Is the board notice.
{% endapi-method-parameter %}

{% api-method-parameter name="boardAssignment" type="boolean" required=true %}
Is the board assignment.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Board edit complete successfully.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 200 }
```

{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```

{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/board/delete" %}
{% api-method-summary %}
deleteBoard
{% endapi-method-summary %}

{% api-method-description %}
Delete board. In fact, it just be invisible.
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="boardId" type="integer" required=true %}
Id of the board you deleted.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Board delete complete successfully.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 200 }
```

{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```

{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}
