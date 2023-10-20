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
    - [Child](#child)
    - [Get a Child](#get-a-child)
    - [Get Children](#get-children)
  - [Messages](#messages)
    - [Message](#message)
    - [Get a Message](#get-a-message)
    - [Get Messages](#get-messages)
    - [Create a Message](#create-a-message)
    - [Update a Message](#update-a-message)
    - [Delete a Message](#delete-a-message)

## Groups

### Group
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "count":  0,
    "properties": [
        {
            "name": "string",
            "operator": "string"
            "value": "string"
        },
    ]
}
```

### Get All Groups

`GET` /groups

**Query**

|Parameter|Value|
|-|-|
|page|0|
|pageSize|0|

**Response**
```javascript
{
    "items": [
        {
            "id": "00000000-0000-0000-0000-000000000000",
            "name": "string",
            "count":  0,
            "properties": [
                {
                    "name": "string",
                    "operator": "string"
                    "value": "string"
                },
            ]
        }
    ],
    "pagination": {
        "page": 0,
        "pageSize": 0,
        "totalItems": 0,
        "totalPages": 0,
        "first": 0,
        "last": 0,
        "prev": 0,
        "next": 0
    }
}
```

### Get a Group

`GET` /groups/{id}

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "count":  0,
    "properties": [
        {
            "name": "string",
            "operator": "string"
            "value": "string"
        },
    ]
}
```

### Create a Group

`POST` /groups

**Request**
```javascript
{
    "name": "string",
    "properties": [
        {
            "name": "string",
            "operator": "string",
            "value": "string"
        },
    ]
}
```

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "count":  0,
    "properties": [
        {
            "name": "string",
            "operator": "string",
            "value": "string"
        },
    ]
}
```

### Update a Group

`PUT` /groups/{id}

**Request**
```javascript
{
    "name": "string",
    "properties": [
        {
            "name": "string",
            "operator": "string",
            "value": "string"
        },
    ]
}
```

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "count":  0,
    "properties": [
        {
            "name": "string",
            "operator": "string",
            "value": "string"
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
    "id": "00000000-0000-0000-0000-000000000000",
    "parentId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "age": 0
}
```

### Get Group Children

`GET` /groups/{id}/children

**Query**

|Parameter|Value|
|-|-|
|page|0|
|pageSize|0|

**Response**
```javascript
{
    "items": [
        {
            "id": "00000000-0000-0000-0000-000000000000",
            "parentId": "00000000-0000-0000-0000-000000000000",
            "name": "string",
            "age": 0
        }
    ],
    "pagination": {
        "page": 0,
        "pageSize": 0,
        "totalItems": 0,
        "totalPages": 0,
        "first": 0,
        "last": 0,
        "prev": 0,
        "next": 0
    }
}
```

## Parents

### Parent
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "location": "string, string",
    "childСount": 0,
    "source": "string",
    "likeCount": 0,
    "dislikeCount": 0,
    "registeredAt": "0000-00-00T00:00:00.000Z",
    "lastActiveAt": "0000-00-00T00:00:00.000Z",
}
```

### Get a Parent

`GET` /parents/{id}

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "location": "string, string",
    "childСount": 0,
    "source": "string",
    "likeCount": 0,
    "dislikeCount": 0,
    "registeredAt": "0000-00-00T00:00:00.000Z",
    "lastActiveAt": "0000-00-00T00:00:00.000Z",
}
```

### Get Parents

`GET` /parents

**Query**

|Parameter|Value|
|-|-|
|page|0|
|pageSize|0|

**Response**
```javascript
{
    "items": [
        {
            "id": "00000000-0000-0000-0000-000000000000",
            "name": "string",
            "location": "string, string",
            "childСount": 0,
            "source": "string",
            "likeCount": 0,
            "dislikeCount": 0,
            "registeredAt": "0000-00-00T00:00:00.000Z",
            "lastActiveAt": "0000-00-00T00:00:00.000Z",
        }
    ],
    "pagination": {
        "page": 0,
        "pageSize": 0,
        "totalItems": 0,
        "totalPages": 0,
        "first": 0,
        "last": 0,
        "prev": 0,
        "next": 0
    }
}
```

### Get Parent Likes

`GET` /parents/{id}/likes

**Query**

|Parameter|Value|
|-|-|
|page|0|
|pageSize|0|

**Response**
```javascript
{
    "items": [
        {
            "messageId": ""
        }
    ],
    "pagination": {
        "page": 0,
        "pageSize": 0,
        "totalItems": 0,
        "totalPages": 0,
        "first": 0,
        "last": 0,
        "prev": 0,
        "next": 0
    }
}
```

### Get Parent Dislikes

`GET` /parents/{id}/dislikes

**Query**

|Parameter|Value|
|-|-|
|page|0|
|pageSize|0|

**Response**
```javascript
{
    "items": [
        {
            "messageId": ""
        }
    ],
    "pagination": {
        "page": 0,
        "pageSize": 0,
        "totalItems": 0,
        "totalPages": 0,
        "first": 0,
        "last": 0,
        "prev": 0,
        "next": 0
    }
}
```


## Children

### Child
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "parentId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "age": 0
}
```

### Get a Child

`GET` /children/{id}

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "parentId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "age": 0
}
```

### Get Children

`GET` /children

**Query**

|Parameter|Value|
|-|-|
|page|0|
|pageSize|0|

**Response**
```javascript
{
    "items": [
        {
            "id": "00000000-0000-0000-0000-000000000000",
            "parentId": "00000000-0000-0000-0000-000000000000",
            "name": "string",
            "age": 0
        }
    ],
    "pagination": {
        "page": 0,
        "pageSize": 0,
        "totalItems": 0,
        "totalPages": 0,
        "first": 0,
        "last": 0,
        "prev": 0,
        "next": 0
    }
}
```

## Messages 

### Message
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "groupId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Get a Message

`GET` /messages/{id}

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "groupId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Get Messages

`GET` /messages

**Query**

|Parameter|Value|
|-|-|
|page|0|
|pageSize|0|

**Response**
```javascript
{
    "items": [
        {
            "id": "00000000-0000-0000-0000-000000000000",
            "groupId": "00000000-0000-0000-0000-000000000000",
            "content": "string",
            "name": "string",
            "startDate": "0000-00-00T00:00:00.000Z",
            "repeatDays": 0
        }
    ],
    "pagination": {
        "page": 0,
        "pageSize": 0,
        "totalItems": 0,
        "totalPages": 0,
        "first": 0,
        "last": 0,
        "prev": 0,
        "next": 0
    }
}
```

### Create a Message

`POST` /messages

**Request**
```javascript
{
    "groupId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "groupId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Update a Message

`PUT` /messages/{id}

**Request**
```javascript
{
    "groupId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

**Response**
```javascript
{
    "id": "00000000-0000-0000-0000-000000000000",
    "groupId": "00000000-0000-0000-0000-000000000000",
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Delete a Message

`DELETE` /messages/{id}
