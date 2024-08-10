import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import '../Style/DropDown.css';


function DropDown() {
    return (
      <div className="dropdown">
        <button
          className="dropdown-toggle"
          type="button"
          id="dropdownMenuButton"
          data-bs-toggle="dropdown"
          aria-expanded="false"
          style={{backgroundColor:"aliceblue"}}
        >
          Profile
        </button>
        <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton">
          <li><a className="dropdown-item" href="/Profile">Profile</a></li>
         <li><span className="dropdown-item" onClick={()=>{}}>SignOut</span></li>
        </ul>
      </div>
    );
  }
  
  export default DropDown;