# BoardAPI

{% api-method method="post" host="https://api.cakes.com" path="/board/list" %}
{% api-method-summary %}
getBoards
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-query-parameters %}
{% api-method-parameter name="roomName" type="string" required=true %}
Write room name, where boards belong.
{% endapi-method-parameter %}
{% endapi-method-query-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```
[{
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
}]
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

