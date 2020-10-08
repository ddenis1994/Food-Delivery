from flask import Flask, render_template, abort, jsonify, make_response, request
import random


app = Flask(__name__)
hash=random.getrandbits(128)


def get_atho():# TODO need add chaeck atho
    hash = random.getrandbits(128)
    return True





@app.route('/workers')
def workers():
      if get_atho():
          return render_template('Worker.html', hash=hash,workers=get_json_Workers()), 200
      else:
          abort(401)


@app.route("/workers/save", methods=["POST"])
def add():#TODO make  all pass
    req = request.get_json()
    if req['action']=='add':
        pass
    elif req['action']=='remove':
        pass
    elif req['action']=='change':
        pass
    res = make_response(jsonify(req), 200)
    return res

def get_json_Workers():
    pass

#@app.errorhandler(401)
#def custom_401(error):
#    return Response('<Why access is denied string goes here...>', 401, {'WWW-Authenticate':'Basic realm="Login Required"'})

@app.route("/")
def hello():
    return "Hello from Python!"

if __name__ == "__main__":
    app.run(host='0.0.0.0')
