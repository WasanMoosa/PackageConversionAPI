import requests


url = 'http://localhost:8080/convert-measurements'

expected_io = [('aa', [1]),
               ('abbcc', [2, 6]),
               ('dz_a_aazzaaa', [28, 53, 1]),
               ('_', [0]),
               ('a_', [0]),
               ('abcdabcdab', [2, 7, 7]),
               ('abcdabcdab_', [2, 7, 7, 0]),
               ('zdaaaaaaaabaaaaaaaabaaaaaaaabbaa', [34]),
               ('zza_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_', [26]),
               ('za_a_a_a_a_a_a_a_a_a_a_a_a_azaaa', [40, 1])]

for req_inp, expected_output in expected_io:
    response = requests.get(url, params={'input': req_inp})
    output = response.json()

    assert output == expected_output, "Unexpected Output"

print("All test cases passed Successfully!")