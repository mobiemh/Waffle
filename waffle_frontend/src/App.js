import React, { useState } from 'react'
import './App.css';

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
