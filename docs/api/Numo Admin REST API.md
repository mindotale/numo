# Numo! Admin REST API

## Introduction

**API Root:** https://admin.numo.com/api/v1/

## Table of Contents

- [Numo! Admin REST API](#numo-admin-rest-api)
  - [Introduction](#introduction)
  - [Table of Contents](#table-of-contents)
  - [Groups](#groups)
    - [Group](#group)
    - [Get All Groups](#get-all-groups)
    - [Get a Group](#get-a-group)
    - [Create a Group](#create-a-group)
    - [Update a Group](#update-a-group)
    - [Delete a Group](#delete-a-group)
    - [Get a Group Child](#get-a-group-child)
    - [Get Group Children](#get-group-children)
  - [Parents](#parents)
    - [Parent](#parent)
    - [Get a Parent](#get-a-parent)
    - [Get Parents](#get-parents)
    - [Get Parent Likes](#get-parent-likes)
    - [Get Parent Dislikes](#get-parent-dislikes)
  - [Children](#children)
    - [Get a Child](#get-a-child)
    - [Get Children](#get-children)
  - [Messages](#messages)
    - [Get a Message](#get-a-message)
    - [Get Messages](#get-messages)
    - [Create a Message](#create-a-message)
    - [Update a Message](#update-a-message)
    - [Delete a Message](#delete-a-message)

## Groups

### Group
```javascript
{
    "id": "",
    "name": "",
    "count":  0,
    "properties": [
        {
            "name": "",
            "operator": ""
            "value": ""
        },
    ]
}
```

### Get All Groups

`GET` /groups

**Query**

|Parameter|Value|
|-|-|
|offset|0|
|limit|0|

**Response**
```javascript
{
    "offset": 0,
    "limit": 0,
    "groups": [
        {
            "id": "",
            "name": "",
            "count":  0,
            "properties": [
                {
                    "name": "",
                    "operator": ""
                    "value": ""
                },
            ]
        }
    ]
}
```

### Get a Group

`GET` /groups/{id}

**Response**
```javascript
{
    "id": "",
    "name": "",
    "count":  0,
    "properties": [
        {
            "name": "",
            "operator": ""
            "value": ""
        },
    ]
}
```

### Create a Group

`POST` /groups

**Request**
```javascript
{
    "name": "",
    "properties": [
        {
            "name": "",
            "operator": "",
            "value": ""
        },
    ]
}
```

**Response**
```javascript
{
    "id": "",
    "name": "",
    "count":  0,
    "properties": [
        {
            "name": "",
            "operator": "",
            "value": ""
        },
    ]
}
```

### Update a Group

`PUT` /groups/{id}

**Request**
```javascript
{
    "name": "",
    "properties": [
        {
            "name": "",
            "operator": "",
            "value": ""
        },
    ]
}
```

**Response**
```javascript
{
    "id": "",
    "name": "",
    "count":  0,
    "properties": [
        {
            "name": "",
            "operator": "",
            "value": ""
        }
    ]
}
```

### Delete a Group

`DELETE` /groups/{id}

### Get a Group Child

`GET` /groups/{group_id}/children/{child_id}

**Response**
```javascript
{
    "id": "",
    "parentId": "",
    "name": "",
    "age": 0
}
```

### Get Group Children

`GET` /groups/{group_id}/children

**Query**

|Parameter|Value|
|-|-|
|offset|0|
|limit|0|

**Response**
```javascript
{
    "groupId": 0,
    "children": [
        {
            "id": "",
            "parentId": "",
            "name": "",
            "age": 0
        }
    ],
    "offset": 0,
    "limit": 0
}
```

## Parents

### Parent
```javascript
{
    "id": "",
    "name": "",
    "location": "",
    "childСount": 0,
    "source": "",
    "likeCount": 0,
    "dislikeCount": 0,
    "registeredAt": "",
    "lastActiveAt": ""
}
```

### Get a Parent

`GET` /parents/{id}

**Response**
```javascript
{
    "id": "",
    "name": "",
    "location": "",
    "childСount": 0,
    "source": "",
    "likeCount": 0,
    "dislikeCount": 0,
    "registeredAt": "",
    "lastActiveAt": ""
}
```

### Get Parents

`GET` /parents

**Query**

|Parameter|Value|
|-|-|
|offset|0|
|limit|0|

**Response**
```javascript
{
    "parents": [
        {
            "id": "",
            "name": "",
            "location": "",
            "childСount": 0,
            "source": "",
            "likeCount": 0,
            "dislikeCount": 0,
            "registeredAt": "",
            "lastActiveAt": ""
        }
    ],
    "offset": 0,
    "limit": 0
}
```

### Get Parent Likes

`GET` /parents/{id}/likes

**Query**

|Parameter|Value|
|-|-|
|offset|0|
|limit|0|

**Response**
```javascript
{
    "parentId": "",
    "likes": [
        {
            "messageId": ""
        }
    ],
    "offset": 0,
    "limit": 0
}
```

### Get Parent Dislikes

`GET` /parents/{id}/dislikes

**Query**

|Parameter|Value|
|-|-|
|offset|0|
|limit|0|

**Response**
```javascript
{
    "parentId": "",
    "dislikes": [
        {
            "messageId": ""
        }
    ],
    "offset": 0,
    "limit": 0
}
```


## Children

### Get a Child

`GET` /children/{id}

**Response**
```javascript
{
    "id": "",
    "parentId": "",
    "name": "",
    "age": 0,
}
```

### Get Children

`GET` /children

**Query**

|Parameter|Value|
|-|-|
|offset|0|
|limit|0|

**Response**
```javascript
{
    "children": [
        {
            "id": "",
            "parentId": "",
            "name": "",
            "age": 0
        }
    ],
    "offset": 0,
    "limit": 0
}
```

## Messages 

### Get a Message

`GET` /messages/{id}

**Response**
```javascript
{
    "id": "",
    "groupId": "",
    "name": "",
    "content": "",
    "startDate": "",
    "repeatDays": 0
}
```

### Get Messages

`GET` /messages

**Query**

|Parameter|Value|
|-|-|
|offset|0|
|limit|0|

**Response**
```javascript
{
    "messages": [
        {
            "id": "",
            "groupId": "",
            "content": "",
            "name": "",
            "startDate": "",
            "repeatDays": 0
        }
    ],
    "offset": 0,
    "limit": 0
}
```

### Create a Message

`POST` /messages

**Request**
```javascript
{
    "groupId": "",
    "name": "",
    "content": "",
    "startDate": "",
    "repeatDays": 0
}
```

**Response**
```javascript
{
    "id": "",
    "groupId": "",
    "name": "",
    "content": "",
    "startDate": "",
    "repeatDays": 0
}
```

### Update a Message

`PUT` /messages/{id}

**Request**
```javascript
{
    "groupId": "",
    "name": "",
    "content": "",
    "startDate": "",
    "repeatDays": 0
}
```

**Response**
```javascript
{
    "id": "",
    "groupId": "",
    "name": "",
    "content": "",
    "startDate": "",
    "repeatDays": 0
}
```

### Delete a Message

`DELETE` /messages/{id}
