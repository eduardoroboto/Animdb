import requests


http="http://"


def test_post_add_to_playlist():

    url = http+"localhost:8080/playlist/edit?productionId=4&playlistId=1"

    payload={}
    headers = {}

    response = requests.request("POST", url, headers=headers, data=payload)

    url = http+"localhost:8080/playlists/favoritos"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert '4' in response.text



def test_delete_remove_from_playlist():

    url = http+"localhost:8080/playlist/edit/3"

    payload={}
    headers = {}

    response = requests.request("DELETE", url, headers=headers, data=payload)

    assert '4' not in response.text

