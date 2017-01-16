using JobDescriptionCsharp.domain;
using JobDescriptionCsharp.validator;
using System.Collections.Generic;
using System.Linq;

namespace JobDescriptionCsharp.repository
{
    public class BaseRepository<GenericType> : IRepository<GenericType> where GenericType : Entity
    {
        protected List<GenericType> items = new List<GenericType>();
        protected IValidator<GenericType> validator;

        public BaseRepository(IValidator<GenericType> validator)
        {
            this.validator = validator;
        }

        public void add(GenericType item)
        {
            validator.validate(item);
            items.Add(item);
        }

        public List<GenericType> getAll()
        {
            return items;
        }

        public GenericType getEntityById(int id)
        {
            var entity = from item in items
                         where item.id == id
                         select item;
            return entity.FirstOrDefault();
        }

        public int getLastId()
        {
            if (items.Count == 0)
                return 0;
            return items.ElementAt(items.Count - 1).id;
        }

        public void remove(GenericType item)
        {
            items.Remove(item);
        }

        public void update(GenericType item)
        {
            validator.validate(item);
            items.Insert(item.id - 1, item);
        }
    }
}
