import Books from "./components/Books/Books";
import Header from "./components/Layout/Header";
import Main from "./components/Layout/Main";

function App() {
  return (
    <>
    <Header />
    <Main>
      <Books />
    </Main>
    </>
  );
}

export default App;
