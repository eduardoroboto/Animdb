import requests


http="http://"
url ="http://localhost:8080/admin"



def test_post_admin():
    url = http+"localhost:8080/admin/"

    payload="{\n    \"name\": \"adminDiferent\",\n    \"email\": \"admin2@animdb.com\",\n    \"password\": \"admin2\"\n}"
    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("POST", url, headers=headers, data=payload)

    url = http+"localhost:8080/admin/?id=3"

    headers = { 'session_id': '1'}

    response = requests.request("GET", url, headers=headers)

    assert response.text == '{"id":3,"name":"adminFake","email":"admin3@animdb.com","password":"admin3","credentials":["admin3@animdb.com","admin3"]}'


def test_put_admin():
    url = http+"localhost:8080/admin/2"

    payload="{\n    \"name\": \"adminAnotherOne\",\n    \"email\": \"admin2@animdb.com\",\n    \"password\": \"admin2\"\n}"
    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("PUT", url, headers=headers, data=payload)

    url = http+"localhost:8080/admin/?id=2"

    headers = { 'session_id': '1'}

    response = requests.request("GET", url, headers=headers)

    assert response.text == '{"id":2,"name":"adminAnotherOne","email":"admin2@animdb.com","password":"admin2","credentials":["admin2@animdb.com","admin2"]}'


def test_put_admin_another_one():
    url = http+"localhost:8080/admin/2"

    payload="{\n    \"name\": \"adminAnotherOneAgain\",\n    \"email\": \"admin2@animdb.com\",\n    \"password\": \"admin2\"\n}"
    headers = {'session_id': '3','Content-Type': 'application/json'}

    response = requests.request("PUT", url, headers=headers, data=payload)

    url = http+"localhost:8080/admin/?id=2"

    headers = { 'session_id': '1'}

    response = requests.request("GET", url, headers=headers)

    assert response.text == '{"id":2,"name":"adminAnotherOne","email":"admin2@animdb.com","password":"admin2","credentials":["admin2@animdb.com","admin2"]}'


def test_get_admin_me():
    url = http+"localhost:8080/admin/me"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == '{"id":1,"name":"adminMaster","email":"admin1@animdb.com","password":"adminmaster","credentials":["admin1@animdb.com","adminmaster"]}'

def test_get_admin():

    url = http+"localhost:8080/admin/?id=1"

    payload={}
    headers = { 'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == '{"id":1,"name":"adminMaster","email":"admin1@animdb.com","password":"adminmaster","credentials":["admin1@animdb.com","adminmaster"]}'

def test_get_admin_another_one():


    url = http+"localhost:8080/admin/?id=1"

    payload={}
    headers = { 'session_id': '2'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == 'null'


def test_delete_admin_me():
    url = http+"localhost:8080/admin/me"

    payload={}
    headers = { 'session_id': '4'}

    response = requests.request("DELETE", url, headers=headers, data=payload)


    url = http+"localhost:8080/admin/?id=4"

    payload={}
    headers = { 'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == 'null'


def test_delete_admin():
    url = http+"localhost:8080/admin/3"

    payload={}
    headers = { 'session_id': '1'}

    response = requests.request("DELETE", url, headers=headers, data=payload)


    url = http+"localhost:8080/admin/?id=3"

    payload={}
    headers = { 'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == 'null'

def test_delete_admin_another_one():
    url = http+"localhost:8080/admin/1"

    payload={}
    headers = { 'session_id': '2'}

    response = requests.request("DELETE", url, headers=headers, data=payload)


    url = http+"localhost:8080/admin/?id=1"

    payload={}
    headers = { 'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == '{"id":1,"name":"adminMaster","email":"admin1@animdb.com","password":"adminmaster","credentials":["admin1@animdb.com","adminmaster"]}'
