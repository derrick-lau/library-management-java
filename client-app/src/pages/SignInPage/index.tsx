import React, { useState } from 'react';
import SignInForm from '../../components/SignInForm';
import SignInRequest from '../../api/SignInRequest';
import {IisSignedInProps, Iadmin} from '../../model/model'

const SignIn : React.FC<IisSignedInProps>= ({setIsSignedIn}) => {

  const [admin, setAdmin] = useState<Iadmin>({ barcode: '', password: ''});

  const onAdminChange = (event:React.ChangeEvent<HTMLInputElement>) => {
    const { value, name } = event.target;
    setAdmin({...admin, [name]: value });
  };

  const SignIn = (event:React.ChangeEvent<HTMLFormElement>) => {
    event.preventDefault();
    SignInRequest('http://127.0.0.1:5000/signin', admin, setIsSignedIn)
  }

  return (
    <SignInForm onAdminChange={onAdminChange} admin={admin} SignIn={SignIn} />
  )
}

export default SignIn;
