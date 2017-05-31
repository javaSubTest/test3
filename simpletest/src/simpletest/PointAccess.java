package simpletest;

/**
 * @author Peter Karich
 */
public interface PointAccess {
    /**
     * @return true if elevation data is stored and can be retrieved
     */
    boolean is3D();

    /**
     * @return 3 if elevation enabled. 2 otherwise
     */
    int getDimension();

    /**
     * This method ensures that the node with the specified index exists i.e. allocates space for
     * it.
     */
    void ensureNode(int nodeId);

    /**
     * This method ensures that the node with the specified index exists and prepares access to it.
     * The index goes from 0 (inclusive) to graph.getNodes() (exclusive)
     * <p>
     * This methods sets the latitude, longitude and elevation to the specified value.
     */
    void setNode(int nodeId, double lat, double lon);

    /**
     * This method ensures that the node with the specified index exists and prepares access to it.
     * The index goes from 0 (inclusive) to graph.getNodes() (exclusive)
     * <p>
     * This methods sets the latitude, longitude and elevation to the specified value.
     */
    void setNode(int nodeId, double lat, double lon, double ele);

    /**
     * @return the latitude at the specified node index
     */
    double getLatitude(int nodeId);

    double getLat(int nodeId);

    /**
     * @return the longitude at the specified node index
     */
    double getLongitude(int nodeId);

    double getLon(int nodeId);

    /**
     * Returns the elevation of the specified nodeId.
     */
    double getElevation(int nodeId);

    double getEle(int nodeId);
}