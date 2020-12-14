import requests


http="http://"


def test_post_production():
    url = http+"localhost:8080/production/"

    payload="{\n    \"title\": \"Breaking Bad The Movie\",\n    \"synopsis\": \"A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future. \",\n    \"status\": \"Finished\",\n    \"author\": \"Vince Gilligan\",\n    \"format\": \"movie\",\n    \"rating\": 9.4,\n    \"duration\": null,\n    \"episodes\": 62\n}"
    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("POST", url, headers=headers, data=payload)

    url = http+"localhost:8080/production/?title=Breaking Bad"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert 'Breaking Bad The Movie' in response.text

def test_get_production_id():
    url = http+"localhost:8080/production/?id=1"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "One Piece" in response.text


def test_get_production_tag():
    url = http+"localhost:8080/production/tag/?tags=fantasy"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Senhor dos Anéis O Retorno do Rei (2003)" in response.text and "O Senhor dos Anéis A Sociedade do Anel (2001)" in response.text

def test_get_production_cast():
    url = http+"localhost:8080/production/cast/2?cast=Bryan Cranston"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("POST", url, headers=headers, data=payload)

    url = http+"localhost:8080/production/cast/?cast=Bryan Cranston"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert 'Breaking Bad' in response.text


def test_get_production_info():
    url = http+"localhost:8080/production/info/?title=Breaking Bad&author=Vince Gilligan&status=Finished&format=serie"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    print(response.text)


    assert 'Breaking Bad' in response.text


def test_put_prodution_id():

    url = http+"localhost:8080/production/1"

    payload="{\n    \"id\": 1,\n    \"title\": \"One Piece\",\n    \"synopsis\": \"Gold Roger was known as the Pirate King, the strongest and most infamous being to have sailed the Grand Line. The capture and death of Roger by the World Government brought a change throughout the world. His last words before his death revealed the location of the greatest treasure in the world, One Piece. It was this revelation that brought about the Grand Age of Pirates, men who dreamed of finding One Piece (which promises an unlimited amount of riches and fame), and quite possibly the most coveted of titles for the person who found it, the title of the Pirate King.\",\n    \"status\": \"Airing\",\n    \"releaseDate\": \"1999-08-20T03:00:00.000+00:00\",\n    \"author\": \"Eichiirou Oda\",\n    \"format\": \"anime\",\n    \"rating\": 8.4,\n    \"duration\": null,\n    \"episodes\": 666\n}"
    headers = {  'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("PUT", url, headers=headers, data=payload)


    url = http+"localhost:8080/production/1"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert '666' in response.text



def test_delete_production_id():
    url = http+"localhost:8080/production/8"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("DELETE", url, headers=headers, data=payload)
    response = requests.request("GET", url, headers=headers, data=payload)

    assert response.text == 'null'

