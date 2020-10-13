from flask import Flask, render_template, abort, jsonify, make_response, request
import random


app = Flask(__name__)
hash=random.getrandbits(128)


def get_atho():# TODO need add chaeck atho
    hash = random.getrandbits(128)
    return True





@app.route('/HFindWorker', methods=['GET'])
def HfindWorker():
    if get_atho():
        return render_template('workerByID.html', hash=hash), 200
    abort(401)




@app.route('/findWorker', methods=['POST'])
def findWorker():
    flag=False
    if request.form['myHash']==hash.__str__():
        flag=True
    if request.form['ID']=="":
        return make_response("sorry need enter worker ID", 205)
    elif flag:
        return make_response(jsonify(get_workerByID(request.form['ID'])), 200)
    abort(401)



@app.route('/workers')
def workers():
      if get_atho():
            return render_template('Worker.html', hash=hash,workers=get_json_Workers()), 200
      else:
          abort(401)


@app.route("/workers/save", methods=["POST"])
def add():#TODO make  all pass
    req = request.get_json()
    if req.get("myHash")==hash.__str__():
        if saveInDB()==False:
            res = make_response(jsonify({'msg':"Sorry, Can't save worker now try later."}), 200)
        else:
            res = make_response(jsonify({'msg': "Success, Worker is save."}), 200)
    else:
        abort(401)
    return res


def saveInDB():
    return  True

def get_json_Workers():
    return  {"workers":[{"name":"dani","tel":"052648789","email":"dasd"},{"name":"dad","tel":"051231232648789","email":"daasdasdsd"}]}

def get_workerByID(ID):
    return {"name": "dani", "tel": "052648789", "email": "dasd"}

#@app.errorhandler(401)
#def custom_401(error):
#    return Response('<Why access is denied string goes here...>', 401, {'WWW-Authenticate':'Basic realm="Login Required"'})

@app.route("/")
def hello():
    return "Hello from Python!"

if __name__ == "__main__":
    app.run(host='0.0.0.0')
