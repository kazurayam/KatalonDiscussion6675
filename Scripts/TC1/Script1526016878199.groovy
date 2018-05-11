import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

File tempDir = new File('C:/temp')
ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir")
pb.directory(tempDir)
Process process = pb.start()
int ret = process.waitFor()

// print output and err
InputStream is = process.getInputStream()
InputStream es = process.getErrorStream()
WebUI.comment("ret=${ret}")
String line = ""
StringBuilder sb = new StringBuilder()
sb.append(">>>stdout")
BufferedReader rout =
	new BufferedReader(new InputStreamReader(is,"Shift_JIS"));
while ((line = rout.readLine())!= null) {
	sb.append(line + "\n");
}
sb.append(">>>stderr")
BufferedReader rerr =
	new BufferedReader(new InputStreamReader(es,"Shift_JIS"));
while ((line = rerr.readLine())!= null) {
	sb.append(line + "\n");
}
WebUI.comment("dir . : ${sb.toString()}")