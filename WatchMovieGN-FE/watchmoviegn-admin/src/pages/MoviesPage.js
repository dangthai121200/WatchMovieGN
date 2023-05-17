import { Helmet } from 'react-helmet-async';
import { useState, useEffect } from 'react';
// @mui
import { Container, Stack, Typography } from '@mui/material';
// components
import { ProductSort, ProductList, ProductCartWidget, ProductFilterSidebar } from '../sections/@dashboard/products';
// react-redux
import { useSelector, useDispatch } from 'react-redux'
// reducers
import { getAllMovieAction } from '../reducers/movieSlice/movieSlice';



// ----------------------------------------------------------------------

export default function MoviesPage() {

  const dispatch = useDispatch();
  const movieList = useSelector(state => state.movie.list)

  useEffect(()=>{
    dispatch(getAllMovieAction({
      page: 0,
      size: 10
    }));
    console.log(movieList)
  },[])

  const [openFilter, setOpenFilter] = useState(false);

  const handleOpenFilter = () => {
    setOpenFilter(true);
  };

  const handleCloseFilter = () => {
    setOpenFilter(false);
  };

  return (
    <>
      <Helmet>
        <title> Dashboard: Management Movie </title>
      </Helmet>

      <Container>
        <Typography variant="h4" sx={{ mb: 5 }}>
          Movies
        </Typography>

        <Stack direction="row" flexWrap="wrap-reverse" alignItems="center" justifyContent="flex-end" sx={{ mb: 5 }}>
          <Stack direction="row" spacing={1} flexShrink={0} sx={{ my: 1 }}>
            <ProductFilterSidebar
              openFilter={openFilter}
              onOpenFilter={handleOpenFilter}
              onCloseFilter={handleCloseFilter}
            />
            <ProductSort />
          </Stack>
        </Stack>

        {/* <ProductList products={PRODUCTS} /> */}
        <ProductCartWidget />
      </Container>
    </>
  );
}
