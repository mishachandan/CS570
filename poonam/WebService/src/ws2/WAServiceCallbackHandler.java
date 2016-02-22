
/**
 * WAServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.2  Built on : Sep 06, 2010 (09:42:01 CEST)
 */

    package ws2;

    /**
     *  WAServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WAServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WAServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WAServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getDescription method
            * override this method for handling normal response from getDescription operation
            */
           public void receiveResultgetDescription(
                    ws2.WAServiceStub.GetDescriptionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDescription operation
           */
            public void receiveErrorgetDescription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for avgTemp method
            * override this method for handling normal response from avgTemp operation
            */
           public void receiveResultavgTemp(
                    ws2.WAServiceStub.AvgTempResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from avgTemp operation
           */
            public void receiveErroravgTemp(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getForecast method
            * override this method for handling normal response from getForecast operation
            */
           public void receiveResultgetForecast(
                    ws2.WAServiceStub.GetForecastResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getForecast operation
           */
            public void receiveErrorgetForecast(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for minTemp method
            * override this method for handling normal response from minTemp operation
            */
           public void receiveResultminTemp(
                    ws2.WAServiceStub.MinTempResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from minTemp operation
           */
            public void receiveErrorminTemp(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for maxTemp method
            * override this method for handling normal response from maxTemp operation
            */
           public void receiveResultmaxTemp(
                    ws2.WAServiceStub.MaxTempResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from maxTemp operation
           */
            public void receiveErrormaxTemp(java.lang.Exception e) {
            }
                


    }
    