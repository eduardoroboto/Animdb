import requests

url ="http://localhost:8080/usuarios"




def test_post_usuarios_and_get_id():
    url ="http://localhost:8080/usuarios"
    payload="{\n    \"name\": \"frankenstein\",\n    \"email\": \"frankenstein@monster.com\",\n    \"password\": \"hi123\"\n}"
    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("POST", url, headers=headers, data=payload)

    headers = {'session_id': '1'}
    url = "http://localhost:8080/usuarios/?id=03"
    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == '{"id":3,"name":"frankenstein","email":"frankenstein@monster.com","password":"hi123","playlists":[]}'


def test_get_search_usuario_not_admin():
    url = "http://localhost:8080/usuarios/search?name=Dracula"

    headers = {'session_id': '0','Content-Type': 'application/json'}

    response = requests.request("GET", url, headers=headers)

    assert response.text == "[]"


def test_get_search_usuario_admin():
    url = "http://localhost:8080/usuarios/search?name=Eduardo"

    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("GET", url, headers=headers)

    assert response.text == '[{"id":1,"name":"Eduardo","email":"eduardo@gmail.com","password":"edu12345","playlists":[{"id":1,"name":"favoritos","usuarioId":1,"playlistItemList":[{"id":1,"playlistId":1,"productionId":1},{"id":2,"playlistId":1,"productionId":2}]}]}]'


def test_put_me_usuario():
    url = "http://localhost:8080/usuarios/me"

    payload="{\n    \"id\": 2,\n    \"name\": \"Dede\",\n    \"email\": \"dede@outlook.com\",\n    \"password\": \"dede54321\"\n}"
    headers = {'session_id': '2','Content-Type': 'application/json'}

    response = requests.request("PUT", url, headers=headers, data=payload)
    url = "http://localhost:8080/usuarios/?id=2"
    headers = {'session_id': '2','Content-Type': 'application/json'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == '{"id":2,"name":"Dede","email":"dede@outlook.com","password":"dede54321","playlists":[]}'


def test_put_id_usuario_admin():
    url = "http://localhost:8080/usuarios/2"

    payload="{\n    \"id\": 2,\n   \"name\": \"Dede\",\n    \"email\": \"dede@hotmail.com\",\n    \"password\": \"dede54321\"\n}"
    headers = {'session_id': '1','Content-Type': 'application/json'}
    response = requests.request("PUT", url, headers=headers, data=payload)

    url = "http://localhost:8080/usuarios/?id=2"
    headers = {'session_id': '1','Content-Type': 'application/json'}
    response = requests.request("GET", url, headers=headers)


    assert response.text == '{"id":2,"name":"Dede","email":"dede@hotmail.com","password":"dede54321","playlists":[]}'



def test_put_id_usuario_not_admin():
    url = "http://localhost:8080/usuarios/2"

    payload="{\n    \"id\": 2,\n   \"name\": \"Dede\",\n    \"email\": \"dede@yahoo.com\",\n    \"password\": \"dede54321\"\n}"
    headers = {'session_id': '666','Content-Type': 'application/json'}
    response = requests.request("PUT", url, headers=headers, data=payload)

    url = "http://localhost:8080/usuarios/?id=2"
    headers = {'session_id': '1','Content-Type': 'application/json'}
    response = requests.request("GET", url, headers=headers)


    assert response.text == '{"id":2,"name":"Dede","email":"dede@hotmail.com","password":"dede54321","playlists":[]}'




def test_get_search_usuario_fullname_admin():
    url = "http://localhost:8080/usuarios/search?name=Eduardo"

    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("GET", url, headers=headers)

    assert response.text == '[{"id":1,"name":"Eduardo","email":"eduardo@gmail.com","password":"edu12345","playlists":[{"id":1,"name":"favoritos","usuarioId":1,"playlistItemList":[{"id":1,"playlistId":1,"productionId":1},{"id":2,"playlistId":1,"productionId":2}]}]}]'





def test_get_search_usuario_substring_admin():
    url = "http://localhost:8080/usuarios/search?name=d"

    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("GET", url, headers=headers)
    assert response.text == '[{"id":1,"name":"Eduardo","email":"eduardo@gmail.com","password":"edu12345","playlists":[{"id":1,"name":"favoritos","usuarioId":1,"playlistItemList":[{"id":1,"playlistId":1,"productionId":1},{"id":2,"playlistId":1,"productionId":2}]}]},{"id":2,"name":"Dede","email":"dede@hotmail.com","password":"dede54321","playlists":[]}]'


def test_delete_me_usuario():
    url = "http://localhost:8080/usuarios/me"

    headers = {'session_id': '2','Content-Type': 'application/json'}

    response = requests.request("DELETE", url, headers=headers)
    
    response = requests.request("GET", url, headers=headers)

    assert response.text == "null"

def delete_usuario_admin():
    url = "http://localhost:8080/usuarios/?id=3"

    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("DELETE", url, headers=headers)
    
    url = "http://localhost:8080/usuarios/?id=3"
    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("GET", url, headers=headers)

    assert response.text == "null"



def test_delete_usuario_not_admin():
    url = "http://localhost:8080/usuarios/1"

    headers = {'session_id': '666','Content-Type': 'application/json'}

    response = requests.request("DELETE", url, headers=headers)
    
    url = "http://localhost:8080/usuarios/?id=1"
    headers = {'session_id': '1','Content-Type': 'application/json'}
    response = requests.request("GET", url, headers=headers)

    assert response.text == '{"id":1,"name":"Eduardo","email":"eduardo@gmail.com","password":"edu12345","playlists":[{"id":1,"name":"favoritos","usuarioId":1,"playlistItemList":[{"id":1,"playlistId":1,"productionId":1},{"id":2,"playlistId":1,"productionId":2}]}]}'
