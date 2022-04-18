// Header 영역을 담당하는 Header 컴포넌트 작성

// import css
import classes from './Header.module.css';
import HeaderCart from './HeaderCart';

// Header 컴포넌트
const Header = () => {
    return (
        <>
        <header className={classes.header}>
            <h1>Book Order App</h1>
            <HeaderCart />
        </header>
        </>
    );
};

export default Header;