import React, { useState } from 'react';
import axios from 'axios';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBCheckbox
} from 'mdb-react-ui-kit';

function Register() {
  const [name, setName] = useState('');
  const [age, setAge] = useState('');
  const [add, setAdd] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');


  const handleRegister = async () => {
    try {
      const response = await axios.post('http://localhost:8080/User', {
        name,
        age,
        add,
        email,
        password
      });

      // Handle successful registration response
      console.log(response.data); // Assuming the response contains user data

    } catch (error) {
      // Handle error
      console.log(error);
    }
  };

  return (
    <form>
      <MDBContainer fluid className='d-flex align-items-center justify-content-center bg-image' style={{ backgroundImage: 'url(https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp)' }}>
        <div className='mask gradient-custom-3'></div>
        <MDBCard className='m-5' style={{ maxWidth: '600px' }}>
          <MDBCardBody className='px-5'>
            <h2 className="text-uppercase text-center mb-5">Create an account</h2>
            <MDBInput wrapperClass='mb-4' label='Your Name' size='lg' id='form1' type='text' value={name} onChange={(e) => setName(e.target.value)} />
            <MDBInput wrapperClass='mb-4' label='Your Age' size='lg' id='form1' type='number' value={age} onChange={(e) => setAge(e.target.value)} />
            <MDBInput wrapperClass='mb-4' label='Your Add' size='lg' id='form1' type='text' value={add} onChange={(e) => setAdd(e.target.value)} />
            <MDBInput wrapperClass='mb-4' label='Your Email' size='lg' id='form2' type='email' value={email} onChange={(e) => setEmail(e.target.value)} />
            <MDBInput wrapperClass='mb-4' label='Password' size='lg' id='form3' type='password' value={password} onChange={(e) => setPassword(e.target.value)} />

            <div className='d-flex flex-row justify-content-center mb-4'>
              <MDBCheckbox name='flexCheck' id='flexCheckDefault' label='I agree all statements in Terms of service' />
            </div>
            <MDBBtn type='submit' className='mb-4 w-100 gradient-custom-4' size='lg' onClick={handleRegister}>Register</MDBBtn>
          </MDBCardBody>
        </MDBCard>
      </MDBContainer>
    </form>
  );
}

export default Register;