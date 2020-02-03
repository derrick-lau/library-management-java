import React from 'react';
import { Link } from 'react-router-dom';
import { ReactComponent as Logo } from '../../assets/logo.svg';
import './index.scss';
import { Button } from 'react-bootstrap';
import { useSelector, useDispatch} from 'react-redux';
const Header:React.FC = () => {
    const dispatch = useDispatch();
    return (
    <header>
        <Logo className='logo'/>
        <nav>
            <Link className='route' to='/'>
                <Button variant="light">
                    Home
                </Button>
            </Link>
            <Link className='route' to='/' onClick = { ()=>{dispatch({type:"SET_FALSE"}); window.sessionStorage.clear();} }>
                <Button variant="light">
                    Sign out
                </Button>
            </Link>
        </nav>
    </header>
    )
};
export default Header;
