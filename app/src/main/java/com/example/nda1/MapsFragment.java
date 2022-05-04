package com.example.nda1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback,GoogleMap.OnMapClickListener {
    private GoogleMap gMap;
    private View v;
    private  MotionLayout ml;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v=view;
        ml=v.findViewById(R.id.ml);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;

        gMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                String[] str=marker.getSnippet().split("---");
                ImageView imageViewmara1=v.findViewById(R.id.imageViewmara1);
                TextView textViewmara1=v.findViewById(R.id.textViewmara1);
                textViewmara1.setText(marker.getTitle().toUpperCase()+"\n\n"+str[0]);
                imageViewmara1.setImageResource(getResources().getIdentifier("@drawable/"+str[1], "string", getContext().getPackageName()));
                ml.transitionToEnd();
                return true;
            }
        });
        gMap.clear();

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        crearicon((BitmapDrawable)getResources().getDrawable(R.drawable.macchupicchuicon),-13.1542,-72.5253,"Machupicchu","Descubierta en el año 1902 por Agustín Lizárraga y dada a conocer al mundo en 1911 por Hiram Bingham, la ciudad “perdida” de los Incas fue construida a mediados del siglo XV d. C por órdenes del Inca Pachacútec. Si bien este centro arqueológico no tiene nombre, Machu Picchu, la montaña donde se encuentra ubicada, significa en quechua “Montaña Vieja”. Según investigaciones, este lugar servía como un espacio de reposo para el Inca y estaba destinado a albergar un aproximado de 300 personas.---machupicchu");
        crearicon((BitmapDrawable)getResources().getDrawable(R.drawable.chichenitsaicon),20.66667,-88.56667,"Chichén Itzá","En el idioma Maya, su nombre significa “Boca del Pozo de los Brujos del Agua” ya que, según la creencia de esa época, el cenote sagrado servía como entrada al inframundo.Inaugurada en el año 525 d.C., este “castillo”, como denominaron los conquistadores españoles a esta maravilla mundial, sirvió como templo para el dios Kukulkán y consiste en una pirámide con una serie de terrazas cuadradas con escaleras que suben desde cada uno de los cuatro lados la misma hasta la parte superior. Fue declarada Patrimonio de la Humanidad por la UNESCO en el año 1988.---chichenitza");
        crearicon((BitmapDrawable)getResources().getDrawable(R.drawable.coliseoromanoicon),41.890209,12.492231,"Coliseo Romano","Este anfiteatro, el cual es el tesoro que el Imperio Romano dejó como herencia a la Ciudad Eterna, es una de las 7 maravillas del mundo moderno debido a que es el más grande nunca antes construido en el mundo. Su nombre original fue Anfiteatro Flavio y aquí se organizaban las luchas de los gladiadores, entre otros espectáculos. Funcionó durante más de 500 años y fue construido para soportar a más de 50 mil espectadores. Hoy en día es un atractivo turístico que atrae cada año a más de 100 mil turistas a la ciudad de la luz.---coliseoromano");
        crearicon((BitmapDrawable)getResources().getDrawable(R.drawable.cristoredentoricon),-22.951916,-43.2104872,"Cristo Redentor","Otra de las 7 maravillas del mundo moderno es la gran estatua de Jesús de Nazaret con los brazos abiertos que se ve desde cualquier punto de la ciudad de Río de Janeiro en Brasil. Este monumento Art Decó de 30 metros de altura en lo más alto del cerro Corcovado fue inaugurado en 1931 y es el fruto del trabajo en conjunto del escultor polaco-francés Paul Landowski y del ingeniero brasileño Heitor da Silva Costa. Como dato curioso, la estatua fue construida en Francia y llegó a Brasil en cientos de partes solo para ser ensamblada desde la cabeza hasta los pies para poder ser levantada en el cerro.---cristoredentor");
        crearicon((BitmapDrawable)getResources().getDrawable(R.drawable.murallachinaicon),40.4319077,116.5703749,"Gran Muralla China","Esta maravilla del mundo moderno, la cual es la construcción emblemática de todo China, sirvió como fortaleza a base de piedra, ladrillo, madera y tierra apisonada para proteger a este país asiático de las posibles invasiones de los mongoles por el norte. Originalmente llegó a medir más de 21 mil kilómetros cuando fue construida entre los siglos V a.c. y XVI d.c. (¡Más de 2000 años!) y millones de obreros perdieron la vida durante su construcción, lo que la convierte también en el mayor y más grande cementerio del mundo ya que estas personas fueron enterradas ahí. Existe una creencia que dicta que esta construcción puede ser divisada desde el espacio, pero fue desmentida por distintos astronautas.---murallachina");
        crearicon((BitmapDrawable)getResources().getDrawable(R.drawable.tajmahalicon),27.173891,78.042068,"Taj Mahal","Si hablamos de las 7 maravillas del mundo moderno, no podemos olvidarnos del apoteósico Taj Mahal. Posiblemente, este es el edificio más romántico del mundo, pues fue construido a mediados del siglo XVII por el emperador Shah Jahan como mausoleo para enterrar a su difunta esposa. Se dice que el emperador estaba tan enamorado de ella que ordenó construir el mausoleo más bello y grandioso en su honor. Mide 42 acres que incluyen una mezquita y una casa de huéspedes, además de los jardines. El nombre de este edificio hace referencia a Arjumand, su difunta esposa, quien era conocida como Mumtaz Mahal que en persa significa “Elegida del Palacio” o “Primera Dama del Palacio”; mientras que “Taj” significa “corona”. Por ende, el nombre del Taj Mahal significa “Corona de Mahal”.---tajmahal");
        crearicon((BitmapDrawable)getResources().getDrawable(R.drawable.petraicon), 30.328960, 35.444832,"Petra","Originalmente conocida como Raqmu, la ciudad de Piedra le valió un lugar entre las 7 maravillas del mundo moderno por su arquitectura excavada en la roca, así como también por su avanzado sistema de conductos de agua. La ciudad de Petra, construida muy posiblemente ya en el año 312 a.C como la capital de los nabateos árabes, era el lugar de paso de las caravanas que transportaban especias, incienso y productos de lujo entre Arabia, Siria, Egipto y el Sur del Mediterráneo. Sus altos muros, los cuales albergaban tanto agua potable como seguridad a los mercaderes, son un símbolo definitivo de Jordania. Fue declarada Patrimonio de la Humanidad por la UNESCO en 1985.---ciudaddepetra");



        gMap.setMyLocationEnabled(true);

    }

    public void crearicon(BitmapDrawable bitma,Double lat,Double lon,String title,String desc){
        LatLng ubiMP=new LatLng(lat, lon);
        Bitmap smallMarker = Bitmap.createScaledBitmap(bitma.getBitmap(), 60, 60, false);

        gMap.addMarker(new MarkerOptions().position(ubiMP).title(title).snippet(desc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com"));
        startActivity(intent);
    }
}