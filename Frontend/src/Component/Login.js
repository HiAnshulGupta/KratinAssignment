import React, { useState } from 'react';
import { Link } from "react-router-dom"
import axios from 'axios';
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import 'mdb-react-ui-kit/dist/css/mdb.rtl.min.css';
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBInput
} from 'mdb-react-ui-kit';
import "./Login.css";
import logo from "../Image/kratin.png";


const LoginForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
        try {
            const response = await axios.post('http://localhost:8080/User/login', {
                email,
                password
            });

            // Handle successful login response
            console.log(response.data); // Assuming the response contains user data
            
            const userId = response.data.id;
            // Navigate to the profile page
            window.location.href = `/User/login/${userId}`;
        } catch (error) {
            // Handle error
            console.log(error);
        }
    };

    return (
        <form>
            <MDBContainer className="my-5 gradient-form">
                <MDBRow>
                    <MDBCol col='6' className="mb-5">
                        <div className="d-flex flex-column ms-5">
                            <div className="text-center">
                                <img src={logo}
                                    style={{ width: '185px' }} alt="logo" />
                                <h4 className="mt-1 mb-5 pb-1">We are The Kratin Team</h4>
                            </div>
                            <p>Please login to your account</p>
                            <MDBInput wrapperClass='mb-4' label='Email address' id='form1' type='email' onChange={(e) => setEmail(e.target.value)} />
                            <MDBInput wrapperClass='mb-4' label='Password' id='form2' type='password' onChange={(e) => setPassword(e.target.value)} />
                            <div className="text-center pt-1 mb-5 pb-1">
                                <MDBBtn className="mb-4 w-100 gradient-custom-2" onClick={handleLogin}>Sign in</MDBBtn>
                                <a className="text-muted" href="#!">Forgot password?</a>
                            </div>
                            <div className="d-flex flex-row align-items-center justify-content-center pb-4 mb-4">
                                <p className="mb-0">Don't have an account?</p>
                                <MDBBtn outline className='mx-2' color='danger'>
                                    <Link to="/Register">Create new</Link>
                                </MDBBtn>
                            </div>
                        </div>
                    </MDBCol>
                    <MDBCol col='6' className="mb-5">
                        <div className="d-flex flex-column justify-content-center gradient-custom-2 h-100 mb-4">
                            <div className="text-white px-3 py-4 p-md-5 mx-md-4">
                                <h4 class="mb-4">We are more than just a company</h4>
                                <p class="small mb-0">At Kratin Group, we are committed to provideproducts and services which bring positive change in the life of people and thereby create tangible value for all stakeholders.</p>
                            </div>
                        </div>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
        </form>
    );
};

export default LoginForm;