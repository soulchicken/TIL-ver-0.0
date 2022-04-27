import Button from "./Button";
import styles from "./App.module.css"
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1 className={styles.title}>Hello</h1>
        <Button text={"Continue"}/>
      </header>
    </div>
  );
}

export default App;
