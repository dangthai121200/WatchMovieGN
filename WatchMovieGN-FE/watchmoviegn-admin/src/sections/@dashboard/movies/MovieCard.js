import PropTypes from 'prop-types';
// @mui
import { Box, Card, Link, Typography, Stack, Rating } from '@mui/material';
import { styled } from '@mui/material/styles';
// utils
import { fCurrency } from '../../../utils/formatNumber';
// components
import Label from '../../../components/label';
import { ColorPreview } from '../../../components/color-utils';

// ----------------------------------------------------------------------

const StyledMovieImg = styled('img')({
  top: 0,
  width: '100%',
  height: '100%',
  objectFit: 'cover',
  position: 'absolute',
});

// ----------------------------------------------------------------------

MovieCard.propTypes = {
  product: PropTypes.object,
};

export default function MovieCard({ movie }) {
  const { pkIdMovie, name, urlImage, status, time } = movie;
  return (
    <Card>
      <Box sx={{ pt: '100%', position: 'relative' }}>
        {status && (
          <Label
            variant="filled"
            color={(status === 'sale' && 'error') || 'info'}
            sx={{
              zIndex: 9,
              top: 16,
              right: 16,
              position: 'absolute',
              textTransform: 'uppercase',
            }}
          >
            {status}
          </Label>
        )}
        <StyledMovieImg alt={name} src={urlImage} loading='lazy'/>
      </Box>

      <Stack spacing={2} sx={{ p: 3 }}>
        <Link color="inherit" underline="hover">
          <Typography variant="subtitle2" noWrap>
            {name}
          </Typography>
        </Link>

        <Stack direction="row" alignItems="center" justifyContent="space-between">
        <Rating name="read-only" value={3} readOnly />
          <Typography variant="subtitle1">
            {time}ph
          </Typography>
        </Stack>
      </Stack>
    </Card>
  );
}
