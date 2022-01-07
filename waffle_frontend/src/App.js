import React, { useState } from 'react'
import './App.css';
import { Client } from '@stomp/stompjs'

const client = new Client({
  brokerURL: 'ws://localhost:8080/ws',
  // connectHeaders: {
  //   login: 'user',
  //   passcode: 'password',
  // },
  debug: function (str) {
    console.log(str);
  },
  reconnectDelay: 5000,
  heartbeatIncoming: 4000,
  heartbeatOutgoing: 4000,
  onConnect: function (frame) {
    // The return object has a method called `unsubscribe`
    const subscription = client.subscribe('/topic/test', function (message) {
      console.log('received!!' + message)
      // const payload = JSON.parse(message.body);
      // displayIncomingMessage(payload.user, payload.message);
    });    
  }
});

client.activate();

var fn = () => client.publish({destination: '/app/ws', body: JSON.stringify([111])})
setTimeout(fn, 3000)

// var subscription = client.subscribe('/topic', msg => console.log(msg));

// client.onStompError = function (frame) {
//   // Will be invoked in case of error encountered at Broker
//   // Bad login/passcode typically will cause an error
//   // Complaint brokers will set `message` header with a brief message. Body may contain details.
//   // Compliant brokers will terminate the connection after any error
//   console.log('Broker reported error: ' + frame.headers['message']);
//   console.log('Additional details: ' + frame.body);
// };


function App() {
  const [jobId, setJobId] = useState(0)
  const [jobName, setJobName] = useState("")
  const [contents, setContents] = useState([])

  const addContents = async (_jobName) => {
    const response = await fetch('http://localhost:8080/job', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({name: _jobName})
    })

    setJobId(jobId+1)
    setContents([<li key={jobId}>{_jobName}</li>, ...contents])
  }

  return (
    <div className="App">
      <div>
        <input type="text" value={jobName} onChange={e => setJobName(e.target.value)}></input>
        <input type="button" value="일정 추가" onClick={() => {addContents(jobName)}}></input>
      </div>
      <ul>
        {contents}
      </ul>
    </div>
  );
}

export default App;
