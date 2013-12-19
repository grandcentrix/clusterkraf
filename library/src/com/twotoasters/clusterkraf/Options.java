package com.twotoasters.clusterkraf;

import com.twotoasters.clusterkraf.Clusterkraf.ProcessingListener;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/**
 * Specify options for the Clusterkraf instance here
 */
public class Options {

	public enum ClusterClickBehavior {
		ZOOM_TO_BOUNDS, SHOW_INFO_WINDOW, NO_OP
	}
	public enum ClusterInfoWindowClickBehavior {
		ZOOM_TO_BOUNDS, HIDE_INFO_WINDOW, NO_OP
	}

	public enum SinglePointClickBehavior {
		SHOW_INFO_WINDOW, NO_OP
	}

	public enum SinglePointInfoWindowClickBehavior {
		HIDE_INFO_WINDOW, NO_OP
	}

	private static final int DEFAULT_TRANSITION_DURATION = 300;

	private static final int DEFAULT_PIXEL_DISTANCE_TO_JOIN_CLUSTER = 150;

	private static final double DEFAULT_EXPAND_BOUNDS_FACTOR = 0;

	private final int DEFAULT_SHOW_INFO_WINDOW_ANIMATION_DURATION = 300;

	private final int DEFAULT_ZOOM_TO_BOUNDS_ANIMATION_DURATION = 300;

	/**
	 * The behavior when a cluster's marker is clicked
	 */
	private ClusterClickBehavior clusterClickBehavior = ClusterClickBehavior.ZOOM_TO_BOUNDS;

	/**
	 * The behavior when a cluster's info window is clicked
	 */
	private ClusterInfoWindowClickBehavior clusterInfoWindowClickBehavior = ClusterInfoWindowClickBehavior.HIDE_INFO_WINDOW;

	/**
	 * How long the ClusteringOnCameraChangeListener should remain dirty. This
	 * should be set to slightly less than the duration of transition animation,
	 * during which time you would not want the user to trigger a cluster update
	 * process, but not so low that panning the map results in continuously
	 * triggering cluster update processes.
	 */
	private long clusteringOnCameraChangeListenerDirtyLifetimeMillis = 200l;

    /**
     * enabels clustering after the maps camera changed. disable this option if you
     * reset the pin on every camera change by your own
     */
    private boolean enableClusteringOnCameraChange = true;

	/**
	 * Defines how much the visible region bounds should be expanded when
	 * considering whether an InputPoint is to be considered for clustering.
	 * Lower values will result in higher drawing performance when many
	 * InputPoint objects are off screen, but clusters will be more likely to
	 * pop into view after the camera has finished moving when panning or
	 * zooming out. Higher values will result in cluster sliding onto the map
	 * smoothly when panning and zooming out, less prone to popping into view,
	 * but at the expense of lower performance because many markers will need to
	 * be drawn off screen.
	 */
	private double expandBoundsFactor = DEFAULT_EXPAND_BOUNDS_FACTOR;

    /**
     * The InfoWindowDownstreamAdapter to receive callbacks when an info window
     * needs to be displayed.
     */
    private InfoWindowDownstreamAdapter infoWindowDownstreamAdapter;

	/**
	 * The MarkerOptionsChooser to use for customizing MarkerOptions objects.
	 */
	private MarkerOptionsChooser markerOptionsChooser;

	/**
	 * The OnInfoWindowClickDownstreamListener to receive callbacks when an info
	 * window is clicked
	 */
	private OnInfoWindowClickDownstreamListener onInfoWindowClickDownstreamListener;

	/**
	 * The OnMarkerClickDownstreamListener to receive callbacks when a marker is
	 * clicked
	 */
	private OnMarkerClickDownstreamListener onMarkerClickDownstreamListener;

	/**
	 * The pixel distance under which an InputPoint will cluster into a
	 * neighbor.
	 */
	private int pixelDistanceToJoinCluster = DEFAULT_PIXEL_DISTANCE_TO_JOIN_CLUSTER;

	/**
	 *
	 */
	private ProcessingListener processingListener;

	/**
	 * The length of the show info window animation in milliseconds
	 */
	private int showInfoWindowAnimationDuration = DEFAULT_SHOW_INFO_WINDOW_ANIMATION_DURATION;

	/**
	 * The behavior when a single point's marker is clicked
	 */
	private SinglePointClickBehavior singlePointClickBehavior = SinglePointClickBehavior.SHOW_INFO_WINDOW;

	/**
	 * The behavior when a single point's info window is clicked
	 */
	private SinglePointInfoWindowClickBehavior singlePointInfoWindowClickBehavior = SinglePointInfoWindowClickBehavior.HIDE_INFO_WINDOW;

	/**
	 * The length of the animated cluster transition in milliseconds
	 */
	private int transitionDuration = DEFAULT_TRANSITION_DURATION;

	/**
	 * The Interpolator used for animating the cluster transition.
	 */
	private Interpolator transitionInterpolator = new LinearInterpolator();

	/**
	 * The length of the zoom to bounds animation in milliseconds
	 */
	private int zoomToBoundsAnimationDuration = DEFAULT_ZOOM_TO_BOUNDS_ANIMATION_DURATION;

	/**
	 * When zooming to the bounds of a marker's backing ClusterPoint, zoom until
	 * all of the points are at least this far from the edge of the GoogleMap's
	 * bounds
	 */
	private int zoomToBoundsPadding = 75;

    /**
     * @return the infoWindowDownstreamAdapter
     */
    public InfoWindowDownstreamAdapter getInfoWindowDownstreamAdapter() {
        return this.infoWindowDownstreamAdapter;
    }

    public boolean isEnableClusteringOnCameraChange() {
        return enableClusteringOnCameraChange;
    }

    /**
	 * @param clusterClickBehavior
	 *            the clusterClickBehavior to set
	 */
	public void setClusterClickBehavior(ClusterClickBehavior clusterClickBehavior) {
		this.clusterClickBehavior = clusterClickBehavior;
	}

	/**
	 * @param clusterInfoWindowClickBehavior
	 *            the clusterInfoWindowClickBehavior to set
	 */
	public void setClusterInfoWindowClickBehavior(ClusterInfoWindowClickBehavior clusterInfoWindowClickBehavior) {
		this.clusterInfoWindowClickBehavior = clusterInfoWindowClickBehavior;
	}

	/**
	 * @param clusteringOnCameraChangeListenerDirtyLifetimeMillis
	 */
	public void setClusteringOnCameraChangeListenerDirtyLifetimeMillis(long clusteringOnCameraChangeListenerDirtyLifetimeMillis) {
		this.clusteringOnCameraChangeListenerDirtyLifetimeMillis = clusteringOnCameraChangeListenerDirtyLifetimeMillis;
	}

    public void setEnableClusteringOnCameraChange(final boolean enableClusteringOnCameraChange) {
        this.enableClusteringOnCameraChange = enableClusteringOnCameraChange;
    }

    /**
	 * @param expandBoundsFactor
	 */
	public void setExpandBoundsFactor(double expandBoundsFactor) {
		this.expandBoundsFactor = expandBoundsFactor;
	}

    /**
     * @param infoWindowDownstreamAdapter
     *            the infoWindowDownstreamAdapter to set
     */
    public void setInfoWindowDownstreamAdapter(InfoWindowDownstreamAdapter infoWindowDownstreamAdapter) {
        this.infoWindowDownstreamAdapter = infoWindowDownstreamAdapter;
    }

	/**
	 * @param markerOptionsChooser
	 *            the markerIconChooser to set
	 */
	public void setMarkerOptionsChooser(MarkerOptionsChooser markerOptionsChooser) {
		this.markerOptionsChooser = markerOptionsChooser;
	}

	/**
	 * @param onInfoWindowClickDownstreamListener
	 *            the onInfoWindowClickDownstreamListener to set
	 */
	public void setOnInfoWindowClickDownstreamListener(OnInfoWindowClickDownstreamListener onInfoWindowClickDownstreamListener) {
		this.onInfoWindowClickDownstreamListener = onInfoWindowClickDownstreamListener;
	}

	/**
	 * @param onMarkerClickDownstreamListener
	 *            the onMarkerClickDownstreamListener to set
	 */
	public void setOnMarkerClickDownstreamListener(OnMarkerClickDownstreamListener onMarkerClickDownstreamListener) {
		this.onMarkerClickDownstreamListener = onMarkerClickDownstreamListener;
	}

	/**
	 * @param pixelDistanceToJoinCluster
	 *            the pixelDistanceToJoinCluster to set. This value should be
	 *            scaled appropriately if you are planning to support multiple
	 *            screen densities. Suggested value: the greater of the width or
	 *            height of your largest marker asset plus 25 percent.
	 */
	public void setPixelDistanceToJoinCluster(int pixelDistanceToJoinCluster) {
		this.pixelDistanceToJoinCluster = pixelDistanceToJoinCluster;
	}

	public void setProcessingListener(ProcessingListener processingListener) {
		this.processingListener = processingListener;
	}

	/**
	 * @param showInfoWindowAnimationDuration
	 *            the showInfoWindowAnimationDuration to set
	 */
	public void setShowInfoWindowAnimationDuration(int showInfoWindowAnimationDuration) {
		this.showInfoWindowAnimationDuration = showInfoWindowAnimationDuration;
	}

	/**
	 * @param singlePointClickBehavior
	 *            the singlePointClickBehavior to set
	 */
	public void setSinglePointClickBehavior(SinglePointClickBehavior singlePointClickBehavior) {
		this.singlePointClickBehavior = singlePointClickBehavior;
	}

	/**
	 * @param singlePointInfoWindowClickBehavior
	 *            the singlePointInfoWindowClickBehavior to set
	 */
	public void setSinglePointInfoWindowClickBehavior(SinglePointInfoWindowClickBehavior singlePointInfoWindowClickBehavior) {
		this.singlePointInfoWindowClickBehavior = singlePointInfoWindowClickBehavior;
	}

	/**
	 * @param transitionDuration
	 *            the transitionDuration to set
	 */
	public void setTransitionDuration(int transitionDuration) {
		this.transitionDuration = transitionDuration;
	}

	/**
	 * @param transitionInterpolator
	 *            the transitionInterpolator to set
	 */
	public void setTransitionInterpolator(Interpolator transitionInterpolator) {
		this.transitionInterpolator = transitionInterpolator;
	}

	/**
	 * @param zoomToBoundsAnimationDuration
	 *            the zoomToBoundsAnimationDuration to set
	 */
	public void setZoomToBoundsAnimationDuration(int zoomToBoundsAnimationDuration) {
		this.zoomToBoundsAnimationDuration = zoomToBoundsAnimationDuration;
	}

	/**
	 * @param zoomToBoundsPadding
	 *            the zoomToBoundsPadding to set
	 */
	public void setZoomToBoundsPadding(int zoomToBoundsPadding) {
		this.zoomToBoundsPadding = zoomToBoundsPadding;
	}

    /**
	 * @return the clusterClickBehavior
	 */
	ClusterClickBehavior getClusterClickBehavior() {
		return clusterClickBehavior;
	}

	/**
	 * @return the clusterInfoWindowClickBehavior
	 */
	ClusterInfoWindowClickBehavior getClusterInfoWindowClickBehavior() {
		return clusterInfoWindowClickBehavior;
	}

	/**
	 * @return the clusteringOnCameraChangeListenerDirtyLifetimeMillis
	 */
	long getClusteringOnCameraChangeListenerDirtyLifetimeMillis() {
		return clusteringOnCameraChangeListenerDirtyLifetimeMillis;
	}

	/**
	 * @return the expandBoundsFactor
	 */
	double getExpandBoundsFactor() {
		return expandBoundsFactor;
	}

	/**
	 * @return the markerOptionsChooser
	 */
	MarkerOptionsChooser getMarkerOptionsChooser() {
		return markerOptionsChooser;
	}

	/**
	 * @return the onInfoWindowClickDownstreamListener
	 */
	OnInfoWindowClickDownstreamListener getOnInfoWindowClickDownstreamListener() {
		return onInfoWindowClickDownstreamListener;
	}

	/**
	 * @return the onMarkerClickDownstreamListener
	 */
	OnMarkerClickDownstreamListener getOnMarkerClickDownstreamListener() {
		return onMarkerClickDownstreamListener;
	}

	/**
	 * @return the pixelDistanceToJoinCluster
	 */
	int getPixelDistanceToJoinCluster() {
		return pixelDistanceToJoinCluster;
	}

	ProcessingListener getProcessingListener() {
		return processingListener;
	}

	/**
	 * @return the showInfoWindowAnimationDuration
	 */
	int getShowInfoWindowAnimationDuration() {
		return showInfoWindowAnimationDuration;
	}

	/**
	 * @return the singlePointClickBehavior
	 */
	SinglePointClickBehavior getSinglePointClickBehavior() {
		return singlePointClickBehavior;
	}

	/**
	 * @return the singlePointInfoWindowClickBehavior
	 */
	SinglePointInfoWindowClickBehavior getSinglePointInfoWindowClickBehavior() {
		return singlePointInfoWindowClickBehavior;
	}

	/**
	 * @return the transitionDuration
	 */
	int getTransitionDuration() {
		return transitionDuration;
	}

	/**
	 * @return the transitionInterpolator
	 */
	Interpolator getTransitionInterpolator() {
		return transitionInterpolator;
	}

	/**
	 * @return the zoomToBoundsAnimationDuration
	 */
	int getZoomToBoundsAnimationDuration() {
		return zoomToBoundsAnimationDuration;
	}

	/**
	 * @return the zoomToBoundsPadding
	 */
	int getZoomToBoundsPadding() {
		return zoomToBoundsPadding;
	}
}