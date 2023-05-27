import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { getAllMovieRequest } from '../../API/movieRequest';
import { MOVIE, REDUX_GET_ALL_MOVIE_ACTION } from '../../constant/API';

export const movieSlice = createSlice({
  name: MOVIE,
  initialState: {
    list: [],
    totalPage: 0,
    totalMovie: 0,
    page: 1,
    size: 20,
    listSize: [20, 40, 60]
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
  if(page === 0 || size === 0) {
    throw new Error('Page and Size than 0');
  }
  const response = await getAllMovieRequest(page - 1 , size);
  return response.data
})

export default movieSlice.reducer;