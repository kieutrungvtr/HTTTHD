using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web;
using Ds.DataAccess;
using Ds.DataAccess.EF;
using Ds.DataAccess.Generic;
using Ds.DataAccess.Dao;

namespace Ds.WebServices.Controllers
{
    public class StaffController : ApiController
    {
        // GET api/values
        public IEnumerable<ds_nhanvien> Get()
        {
            return new BusinessLayer().GetAllStaff();
        }

        // GET api/values/5
        public string Get(int id)
        {
            return "value";
        }

        // POST api/values
        public void Post([FromBody]string value)
        {
        }

        // PUT api/values/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
        }
    }
}