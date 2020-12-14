import requests

http="http://"


def test_get_production_movie():
    url = http+"localhost:8080/production/movie"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    #print(response.text)
    assert "Um Sonho de Liberdade" in response.text 

def test_get_production_movie_title():
    url = http+"localhost:8080/production/movie?title=Um Sonho de Liberdade"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)
    assert "Um Sonho de Liberdade" in response.text 


def test_get_production_movie_title_substring():
    url = http+"localhost:8080/production/movie?title=Sonho"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Um Sonho de Liberdade" in response.text 


def test_get_production_movie_author():

    url = http+"localhost:8080/production/movie?author=Stephen King"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Um Sonho de Liberdade" in response.text 


def test_get_production_movie_author_substring():

    url = http+"localhost:8080/production/movie?author=Stephen"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Um Sonho de Liberdade" in response.text 


def test_get_production_movie_status():
    url = http+"localhost:8080/production/movie?status=Released"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Um Sonho de Liberdade" in response.text 

