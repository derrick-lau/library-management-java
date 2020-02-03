import { SetSignedInActionTypes, SET_TRUE, SET_FALSE } from './TYPES';

export const setIsSignedInTrue = () : SetSignedInActionTypes => ({
    type: SET_TRUE
})

export const setIsSignedInFalse = () : SetSignedInActionTypes => ({
    type: SET_FALSE
})

