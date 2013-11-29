package com.twotoasters.clusterkraf;

import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.model.CameraPosition;

import java.lang.ref.WeakReference;

/**
 * An OnCameraChangeListener that calls back to its host only when appropriate
 */
class ClusteringOnCameraChangeListener implements OnCameraChangeListener {

    interface Host {

        void onClusteringCameraChange(CameraPosition cameraPosition);
    }

    private final WeakReference<Host> hostRef;

    private final Options options;

    private long dirty = 0;

    public ClusteringOnCameraChangeListener(Host host, Options options) {
        this.hostRef = new WeakReference<Host>(host);
        this.options = options;
    }

    @Override
    public void onCameraChange(CameraPosition newPosition) {
        long now = System.currentTimeMillis();
        long notDirtyAfter = now - options.getClusteringOnCameraChangeListenerDirtyLifetimeMillis();
        if (dirty < notDirtyAfter) {
            Host host = hostRef.get();
            if (host != null) {
                dirty = now;
                host.onClusteringCameraChange(newPosition);
            }
        }
    }

    public void setDirty(long when) {
        this.dirty = when;
    }

}
