package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TB_DIM_CHNL_MAGR_CHNL_M",schema="qinhuangdao")
   public class TbDimChnlMagrChnlM {
//渠道码表
		
		private String chnlId;	//渠道编码	
		private String chnlName;	//渠道名称	
		private String chnlType;	//渠道类型	
		
		/**默认的构造方法*/
		
		public TbDimChnlMagrChnlM(){}
		@Id 
		   // @GeneratedValue(strategy = GenerationType.AUTO) 
		@Column(name = "CHNL_ID",length=32)
		public String getChnlId() {
			return chnlId;
		}

		public void setChnlId(String chnlId) {
			this.chnlId = chnlId;
		}
		@Column(name = "CHNL_NAME",length=200)
		public String getChnlName() {
			return chnlName;
		}

		public void setChnlName(String chnlName) {
			this.chnlName = chnlName;
		}
		@Column(name = "CHNL_TYPE",length=100)
		public String getChnlType() {
			return chnlType;
		}

		public void setChnlType(String chnlType) {
			this.chnlType = chnlType;
		};
		
		
		
		
}
