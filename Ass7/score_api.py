from flask import Flask, jsonify

app = Flask(__name__)

num_win = 0
num_loss = 0
num_tie = 0

userName = ["xyz123", "abc234", "sal678", "xyz012", "abc567"]
to_do = {"xyz123": ["Signup", "Upload"], 
"abc234" : "Signup", 
"sal678": ["Upload", "Review"],
"xyz012": "Upload"}

@app.route('/user/<username>', methods=['GET'])
def help(username):

    if(username == "all"):
        return jsonify(
        {
            'Usernames': userName
        }
    )

    exist_count = userName.count(username) 

    if exist_count != 0:
        return jsonify({"message": "Username exists!"}, 200)
    else:
        return jsonify({"message": "Username doesnt exist!"}, 200)

@app.route('/todo/<username>', methods=['GET'])
def todo(username):
    return jsonify(
        {
            'To do': to_do[username]
        }
    )

if __name__ == '__main__':
    app.run(debug=True)
