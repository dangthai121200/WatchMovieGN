import { Helmet } from 'react-helmet-async';
import { useState, useEffect } from 'react';
// @mui
import { Container, Stack, Typography, Pagination, LinearProgress } from '@mui/material';
// components
import { MovieSort, MovieList, MovieCartWidget, MovieFilterSidebar } from '../sections/@dashboard/movies';
// react-redux
import { useSelector, useDispatch } from 'react-redux'
// reducers
import { getAllMovieAction } from '../reducers/movieSlice/movieSlice';
import { REDUCERS_STATUS_LOADING, REDUCERS_STATUS_SUCCEEDED } from '../constant/REDUCERS';



// ----------------------------------------------------------------------

export default function MoviesPage() {

  const dispatch = useDispatch();

  const movieList = useSelector(state => state.movies.list);
  const totalPage = useSelector(state => state.movies.totalPage);
  const [page, setPage] = useState(useSelector(state => state.movies.page));
  const [size, setSize] = useState(useSelector(state => state.movies.size));
  const listSize = useSelector(state => state.movies.size);

  const statusGetMovie = useSelector(state => state.movies.status)

  const [openFilter, setOpenFilter] = useState(false);

  const getAllMovie = (page, size) => {
    dispatch(getAllMovieAction({
      page: page,
      size: size
    }));
  }

  const changePageMovie = (event, page) => {
    dispatch(getAllMovieAction({
      page: page,
      size: size
    }));
    window.scrollTo({ top: 0, behavior: "smooth" });
  }

  const handleOpenFilter = () => {
    setOpenFilter(true);
  };

  const handleCloseFilter = () => {
    setOpenFilter(false);
  };

  useEffect(() => {
    if (movieList.length == 0) {
      getAllMovie(page, size)
    }
  }, [])

  return (
    <>
      <Helmet>
        <title> Dashboard: Management Movie </title>
      </Helmet>

      <Container>

        <Typography variant="h4" sx={{ mb: 5 }}>
          Movies
        </Typography>

        {statusGetMovie == REDUCERS_STATUS_LOADING ? <LinearProgress /> : null}

        <Stack direction="row" flexWrap="wrap-reverse" alignItems="center" justifyContent="flex-end" sx={{ mb: 5 }}>
          <Stack direction="row" spacing={1} flexShrink={0} sx={{ my: 1 }}>
            <MovieFilterSidebar
              openFilter={openFilter}
              onOpenFilter={handleOpenFilter}
              onCloseFilter={handleCloseFilter}
            />
            <MovieSort />
          </Stack>

        </Stack>

        <MovieList movies={movieList} />
        <Container fixed maxWidth="sm">
          <Pagination count={totalPage} color="primary" size="large" sx={{ mt: 2 }} onChange={changePageMovie} />
        </Container>

        <MovieCartWidget />

      </Container>
    </>
  );
}
