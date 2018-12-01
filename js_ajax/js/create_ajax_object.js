function getXMLHTTPRequestObject() {
  let ajax = null;
  if (window.XMLHTTPRequest) {
    ajax = new XMLHTTPRequest;
  } else if (window.ActiveXobject) {
    ajax = new ActiveXobject("MSXML2.XMLHTTP3.0");
  }
  return ajax;
}