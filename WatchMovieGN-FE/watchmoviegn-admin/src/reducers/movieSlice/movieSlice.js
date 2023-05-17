import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { getAllMovieRequest } from '../../API/movieRequest';
import { MOVIE, REDUX_GET_ALL_MOVIE_ACTION } from '../../constant/API';

export const movieSlice = createSlice({
  name: MOVIE,
  initialState: {
    list: [],
    totalPage: 0,
    totalMovie: 0,
    page: 0,
    size: 0
  },
  reducers: {

  },
  extraReducers(builder) {
    builder
      .addCase(getAllMovieAction.pending, (state, action) => {
        state.status = 'loading';
      })
      .addCase(getAllMovieAction.fulfilled, (state, action) => {
        state.status = 'succeeded';
        const { content, totalPages, totalElements, pageable} = action.payload.movies;
        state.list = content;
        state.totalPage = totalPages;
        state.totalMovie = totalElements;
        state.page = pageable.pageNumber;
        state.size = pageable.pageSize;

      })
      .addCase(getAllMovieAction.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      })
  }
})

export const getAllMovieAction = createAsyncThunk(REDUX_GET_ALL_MOVIE_ACTION, async (param) => {
  const { page, size } = param;
  const response = await getAllMovieRequest(page, size);
  return response.data
})

export default movieSlice.reducer;