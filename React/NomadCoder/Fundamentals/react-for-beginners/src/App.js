import Button from "./Button";
import styles from "./App.module.css"
import { useState, useEffect } from "react";
function App() {
  const [counter, setCounter] = useState(0);
  const [keyword, setKeyword] = useState("");
  const onClick = () => setCounter((prev) => prev + 1);
  const onChange = (event) => setKeyword(event.target.value);
  console.log("I run all the time");
  const iRunOnlyOnce = () => {
    console.log("I run only Once!");
  }
  useEffect(() => {
    console.log("CALL THE API...");
  },[]);
  return (
    <div className="App">
      <input value={keyword} onChange={onChange} type="text" placeholder="Search here..." />
      <header className="App-header">
        <h1 className={styles.title}>{counter}</h1>
        <button onClick={onClick}>click me</button>
      </header>
    </div>
  );
}

export default App;
