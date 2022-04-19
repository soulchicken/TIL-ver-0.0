import Books from "./components/Books/Books";
import Cart from "./components/Cart/Cart";
import Header from "./components/Layout/Header";
import Main from "./components/Layout/Main";

function App() {
  return (
    <>
    <Cart />
    <Header />
    <Main>
      <Books />
    </Main>
    </>
  );
}

export default App;
