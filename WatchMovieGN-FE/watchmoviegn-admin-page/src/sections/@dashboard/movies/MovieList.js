import PropTypes from 'prop-types';
// @mui
import { Grid } from '@mui/material';
import MovieCard from './MovieCard';

// ----------------------------------------------------------------------

MovieList.propTypes = {
  movies: PropTypes.array.isRequired,
};

export default function MovieList({ movies, ...other }) {
  console.log(movies)
  return (
    <Grid container spacing={3} {...other}>
      {movies.map((movie) => (
        <Grid key={movie.pkIdMovie} item xs={12} sm={6} md={3}>
          <MovieCard movie={movie} />
        </Grid>
      ))}
    </Grid>
  );
}
