import { configureStore } from '@reduxjs/toolkit'
import movieSlice from './movieSlice/movieSlice'

const store = configureStore({
  reducer: { movies: movieSlice }
})

export default store;