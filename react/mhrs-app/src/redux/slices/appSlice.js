import { createSlice } from "@reduxjs/toolkit";

export const appSlice = createSlice({
  name: "app",
  initialState: {
    hastane: [],
    doktor:[],
    onlineDoktor:[],
  },
  reducers: {
    setHastane: (state, action) => {
      // console.log(action.payload);
      state.hastane = action.payload;
    },
    setAddNewHospital: (state, action) => {
      // console.log(action.payload);
      state.hastane = state.hastane.push(action.payload)
    },
    setDoktor: (state, action) => {
      // console.log(action.payload);
      state.doktor = action.payload;
    },
    setAddNewDoktor: (state, action) => {
      // console.log(action.payload);
      state.doktor = state.doktor.push(action.payload)
    },
    setOnlineDoktor: (state, action) => {
      // console.log(action.payload);
      state.onlineDoktor = action.payload;
    },
    setAddNewOnlineDoktor: (state, action) => {
      // console.log(action.payload);
      state.onlineDoktor = state.onlineDoktor.push(action.payload)
    },

  },
});

export const { setHastane, setAddNewHospital } = appSlice.actions;

export const selectHastane = (state) => state.app.hastane;

// ----------------------------------------------------------

export const { setDoktor, setAddNewDoktor} = appSlice.actions;

export const selectDoktor = (state) => state.app.doktor;

// ----------------------------------------------------------

export const { setOnlineDoktor, setAddNewOnlineDoktor} = appSlice.actions;

export const selectOnlineDoktor = (state) => state.app.onlineDoktor;





export default appSlice.reducer;
