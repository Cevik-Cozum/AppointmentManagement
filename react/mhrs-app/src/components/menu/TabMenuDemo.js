import React, { useState } from 'react';
import { TabMenu } from 'primereact/tabmenu';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Nav, NavItem, NavDropdown, MenuItem, Container } from 'react-bootstrap';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import DataTableCrudHospital from '../management/DataTableCrudHospital';
import DataTableCrudDoktor from '../management/DataTableCrudDoktor';
import DataTableCrudOnlineDoktor from '../management/DataTableCrudOnlineDoktor';
import RandevuAl from '../management/RandevuAl';

const TabMenuDemo = () => {

  const [inMode, setInMode] = useState(false)


  return (

    <div>
      <Router>
        <div>
          <Navbar bg="dark" variant="dark">
            <Container>
            <Navbar.Brand as={Link} to="/randevuAl">Randevu Al</Navbar.Brand>
              <Navbar.Brand as={Link} to="/management">Management</Navbar.Brand>
              <Nav className="me-auto">
                <Nav.Link as={Link} to="/management/hospital" >Hospital</Nav.Link>
                <Nav.Link as={Link} to="/management/doktor" >Doktor</Nav.Link>
                <Nav.Link as={Link} to="/management/onlineDoktor" >OnlineDoktor</Nav.Link>
              </Nav>
            </Container>
          </Navbar>

          <Switch>
            <Route exact path="/management/hospital">
              <Hospital />
            </Route>
            <Route path="/management/doktor">
              <Doktor />
            </Route>
            <Route path="/randevuAl">
              <Randevu/>
            </Route>
            <Route path="/management/onlineDoktor">
              <OnlineDoktor />
            </Route>
          </Switch>
        </div>

      </Router>
    </div>
  );
}
function Hospital() {
  return (
    <div>
      <DataTableCrudHospital />
    </div>
  );
}

function Doktor() {
  return (

    <div>
      <DataTableCrudDoktor />
    </div>
  );
}

function OnlineDoktor() {
  return (
    <div>
      <DataTableCrudOnlineDoktor />
    </div>
  );
}
function Randevu() {
  
  return (
    <div>
      <RandevuAl/>
          </div>
  );
}
export default TabMenuDemo;