package msi.gama.jogl.collada;

public class Input 
{
	
	private String m_semantic = null;
	private String m_source = null;
	private String m_offset = null;
	private String m_set = null;
	
	
	/**---------------GETTER AND SETTER FUNCTIONS-----------------------------**/
	public String getSemantic() {
		return m_semantic;
	}
	
	public void setSemantic(String m_semantic) {
		this.m_semantic = m_semantic;
	}
	
	public String getSource() {
		return m_source;
	}
	
	public void setSource(String m_source) {
		this.m_source = m_source;
	}
	
	public String getOffset() {
		return m_offset;
	}
	
	public void setOffset(String m_offset) {
		this.m_offset = m_offset;
	}

	public String getSet() {
		return m_set;
	}

	public void setSet(String m_set) {
		this.m_set = m_set;
	}	
}