import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faContactCard, faHome, faUser, faUserPlus } from '@fortawesome/free-solid-svg-icons';
import '../Style/Header.css'

const Header = () => {
  return (
    <header className='header'>
      <span className='header-span'>
      <FontAwesomeIcon icon={faHome}/>
      <a className='header-anchor' href='/'>Home</a>
      </span>
      <span className='header-span'>
      <FontAwesomeIcon icon={faContactCard}/>
      <a className='header-anchor' href='/contact'>Contact</a>
      </span>

      

      <span className='header-span'>
      <FontAwesomeIcon icon={faUser}/>
      <a className='header-anchor' href='/Login'>LogIn</a>
      </span>

      <span className='header-span'>
      <FontAwesomeIcon icon={faUserPlus}/>
      <a className='header-anchor' href='/signup'>SignUp</a>
      </span>
  
    </header>
  );
}

export default Header
